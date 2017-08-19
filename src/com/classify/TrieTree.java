package com.classify;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;



/**
 * <pre>
 * Trie���ֳƵ��ʲ��������ֵ�������ʵ��AC�Զ����㷨�Ĺؼ����ݽṹ��
 * AC�Զ����㷨��Ϊ3����
 * (1)����һ��Trie��;
 * (2)����ʧ��ָ��;
 * (3)����AC�Զ�����������������ı���
 * 
 * Trie����3���������ʣ�
 * (1) ���ڵ㲻�����ַ��������ڵ���ÿһ���ڵ㶼ֻ����һ���ַ��� 
 * (2) �Ӹ��ڵ㵽ĳһ�ڵ㣬·���Ͼ������ַ�����������Ϊ�ýڵ��Ӧ���ַ����� 
 * (3) ÿ���ڵ�������ӽڵ�������ַ�������ͬ��
 * 
 * �����ķ���Ϊ:
 * (1) �Ӹ��ڵ㿪ʼһ�������� 
 * (2) ȡ��Ҫ���ҹؼ��ʵĵ�һ���ַ��������ݸ��ַ�ѡ���Ӧ��������ת���������������м����� 
 * (3) ����Ӧ�������ϣ�ȡ��Ҫ���ҹؼ��ʵĵڶ����ַ�,����һ��ѡ���Ӧ���������м����� 
 * (4) �������̡��� 
 * (5) ��ĳ���ڵ㴦���ؼ��ʵ������ַ��ѱ�ȡ�������ȡ���ڸýڵ��ϵ���Ϣ������ɲ��ҡ�
 * </pre>
 * 
 * @author lianxh
 * @since 2013/12/13
 */
public class TrieTree implements KeywordFilter {

	private TrieNode root;

	private boolean compiled = false;

	private Set<Character> skipChars = new HashSet<Character>();

	public TrieTree() {
		this.root = new TrieNode();
	}

	/**
	 * ����Trie������Ϊ���������ݽṹ��
	 * 
	 * @param keyword
	 *            �ؼ����ַ���
	 */
	public void add(String keyword) {
		if (null == keyword || keyword.trim().isEmpty()) {
			throw new IllegalArgumentException("���˹ؼ��ʲ���Ϊ�գ�");
		}
		if (compiled) {
			throw new IllegalStateException("TrieTree�����������ӹؼ���");
		}
		TrieNode last = this.root.extend(keyword.toCharArray());
		last.addResult(keyword);
	}

	public void addSkipChar(char ch) {
		this.skipChars.add(ch);
	}

	public void addSkipChar(Collection<Character> chars) {
		if (null != chars) {
			this.skipChars.addAll(chars);
		}
	}

	/**
	 * ����Trie��
	 */
	public void compile() {
		this.buildFailPath();
		this.compiled = true;
	}

	public String replace(String text, ReplaceStrategy s) {
		checkNotNull(text, "Null value not allowed for parameter 'text'");
		checkNotNull(s, "Null value not allowed for parameter 'strategy'");

		StringBuilder ret = new StringBuilder();
		char[] chars = text.toCharArray();
		TrieNode last = this.root;
		int lastIndex = 0;
		/* ������һ�ַ�ƥ�䵽���ַ������������¡������ء��������� */
		String preKeyword = null;
		/* ��ƥ��Ĺؼ��ʸ��� */
		int cnt = 0;
		for (int i = lastIndex; i < chars.length; i++) {
			char ch = chars[i];
			if (skipChars.contains(ch)) {
				continue;
			}
			while (last.get(ch) == null) {
				if (last == this.root) {
					break;
				}
				last = last.getFail();
			}
			last = last.get(ch);
			if(null == last) {
				last = root;
			}
			if (!last.getResults().isEmpty()) {
				preKeyword = last.getResults().iterator().next();
				cnt++;
				// �Ѿ�ƥ�䵽���������һ���ַ���ֱ���滻
				if (i == chars.length - 1) {
					ret.setLength(ret.length() - (preKeyword.length() - cnt));
					ret.append(s.replaceWith(preKeyword));
				}
			} else if (preKeyword != null) {
				ret.setLength(ret.length() - (preKeyword.length() - cnt));
				ret.append(s.replaceWith(preKeyword));
				ret.append(ch);
				// ����״̬
				preKeyword = null;
				cnt = 0;
			} else {
				ret.append(ch);
			}
		}

		return ret.toString();
	}

	public boolean hasKeywords(String text) {
		checkNotNull(text, "Null value not allowed for parameter 'text'.");

		SearchResult start = new SearchResult(0, this.root);
		return null != continueSearch(text.toCharArray(), start);
	}

	/**
	 * ƥ��ģʽ���г��ֵĵ��ʡ������ǵ�ģʽ����Trie�Ͻ���ƥ��ʱ������뵱ǰ�ڵ�Ĺؼ��ֲ��ܼ���ƥ���ʱ��
	 * ��Ӧ��ȥ��ǰ�ڵ��ʧ��ָ����ָ��Ľڵ��������ƥ�䡣
	 * 
	 * <pre>
	 * ƥ��������£� 
	 * ��root�ڵ㿪ʼ��ÿ�θ��ݶ�����ַ������Զ��������ƶ��� ��������ַ����ڷ�֧�в�����ʱ���ݹ���ʧ��·���������ʧ��·���ߵ���root�ڵ㣬
	 * ���������ַ���������һ���ַ��� ��ΪAC�Զ��������������ı������׺�ƶ��ģ������ڶ�ȡ�����������ı������ݹ���ʧ��·����ֱ��������ڵ㣬
	 * �������Լ������е�ģʽ��
	 * 
	 * �����������
	 * (1)��ǰ�ַ�ƥ�䣬��ʾ�ӵ�ǰ�ڵ�����������һ��·�����Ե���Ŀ���ַ��� ��ʱֻ���ظ�·��������һ���ڵ����ƥ�伴�� ��Ŀ���ַ���ָ�������¸��ַ�����ƥ�䣻
	 * (2)��ǰ�ַ���ƥ�䣬��ȥ��ǰ�ڵ�ʧ��ָ����ָ����ַ�����ƥ�䣬ƥ���������ָ��ָ��root������
	 * �ظ���2�������е�����һ����ֱ��ģʽ���ߵ���βΪֹ��
	 * </pre>
	 * 
	 */
	private SearchResult continueSearch(char[] text, SearchResult lastResult) {
		TrieNode last = lastResult.getLastMatchedNode();
		for (int i = lastResult.getLastIndex(); i < text.length; i++) {
			char ch = text[i];
			// ���������ַ�
			if (skipChars.contains(ch)) {
				continue;
			}

			// �����ǰƥ����ַ���trie�������ӽڵ��Ҳ��Ǹ��ڵ�
			// ��Ҫͨ��ʧ��ָ��ȥ�����ĵ�ǰ�ڵ���ӽڵ�
			while (null != last && last.get(ch) == null) {
				if (last == this.root) {
					break;
				}
				last = last.getFail();
			}
			last = last.get(ch);
			if (null == last) {
				last = this.root;
			}
			if (!last.getResults().isEmpty()) {
				return new SearchResult(i + 1, last);
			}
		}
		return null;
	}

	public int count(String text, String keyword) {
		checkNotNull(text, "Null value not allowed for parameter 'text'.");
		checkNotNull(keyword, "Null value not allowed for parameter 'keyword'.");

		final char[] source = text.toCharArray();
		final char[] target = keyword.toCharArray();
		int cnt = 0;
		for (int i = 0; i < source.length; i++) {
			int k = 0;
			while (i < source.length && k < target.length) {
				// ��ȫƥ�䣬˫���ȶ���һ���ַ�
				if (source[i] == target[k]) {
					k++;
					i++;
				}
				// ��ƥ��, �����������ַ�, ����1���ַ�, ���ؼ��ֲ�����
				else if (skipChars.contains(source[i])) {
					i++;
				}
				// ��ƥ���ֲ��Ǻ����ַ�
				else {
					break;
				}
			}

			if (k == target.length) {
				cnt++;
			}
		}
		return cnt;
	}

	/**
	 * <pre>
	 * ����ʧ��ָ��Ĺ��̸���������һ�仰��������ڵ��ϵ���ĸΪx�����������׵�ʧ��ָ���ߣ�ֱ���ߵ�һ���ڵ㣬���Ķ�����Ҳ����ĸΪx�Ľڵ㡣
	 * Ȼ��ѵ�ǰ�ڵ��ʧ��ָ��ָ���Ǹ��ַ�ҲΪx�Ķ��ӡ����һֱ�ߵ���root��û�ҵ����ǾͰ�ʧ��ָ��ָ��root��
	 * ����������
	 * (1)root���ӽڵ��ʧ��ָ�붼ָ��root��
	 * (2)�ڵ�(�ַ�Ϊx)��ʧ��ָ��ָ�򣺴�X�ڵ�ĸ��ڵ��fail�ڵ����ֱ���ҵ�ĳ�ڵ���ӽڵ�Ҳ���ַ�x��û���ҵ���ָ��root��
	 * </pre>
	 */
	private void buildFailPath() {
		Deque<TrieNode> nodes = new LinkedList<TrieNode>();
		// �ڶ���Ҫ���⴦��������еĽڵ��ʧ��·��ֱ��ָ�򸸽ڵ�(Ҳ���Ǹ��ڵ�)��
		for (char ch : this.root.keys()) {
			TrieNode child = this.root.get(ch);
			child.setFail(this.root);
			nodes.add(child);
		}

		while (!nodes.isEmpty()) {
			TrieNode node = nodes.pop();
			char[] keys = node.keys();
			for (int i = 0; i < keys.length; i++) {
				TrieNode r = node;

				char ch = keys[i];
				TrieNode child = r.get(ch);
				nodes.add(child);

				r = r.getFail();
				while (null != r && r.get(ch) == null) {
					r = r.getFail();
				}
				if(null == r) {
					child.setFail(this.root);
				} else {
					child.setFail(r.get(ch));
					r.getResults().addAll(r.get(ch).getResults());
				}
				
			}
		}
	}

	private void checkNotNull(Object o, String msg) {
		if (o == null) {
			throw new NullPointerException(msg);
		}
	}

}

/**
 * Trie���еĽڵ�
 */
class TrieNode {

	/**
	 * �ӽڵ�
	 */
	private Map<Character, TrieNode> children;

	/**
	 * ʧ��ָ��
	 */
	private TrieNode fail;

	/**
	 * ��ƥ�䵽Щ�ڵ�Ϊֹʱ��ƥ�䵽�Ĺؼ���
	 */
	private Set<String> results = new HashSet<String>();

	public TrieNode() {
		this.children = new LinkedHashMap<Character, TrieNode>();
	}

	/**
	 * ��չ֦��
	 */
	public TrieNode extend(char[] chars) {
		TrieNode node = this;
		for (int i = 0; i < chars.length; i++) {
			node = node.touchChild(chars[i]);
		}
		return node;
	}

	/**
	 * ���򷵻أ�û���򴴽����ٷ���
	 */
	private TrieNode touchChild(char ch) {
		TrieNode child = this.children.get(ch);
		if (child != null) {
			return child;
		}

		TrieNode next = new TrieNode();
		this.children.put(ch, next);
		return next;
	}

	public TrieNode get(char key) {
		return this.children.get(key);
	}

	public void put(char key, TrieNode value) {
		this.children.put(key, value);
	}

	public char[] keys() {
		char[] result = new char[children.size()];
		int i = 0;
		for (Character c : children.keySet()) {
			result[i] = c;
			i++;
		}
		return result;
	}

	public TrieNode getFail() {
		return this.fail;
	}

	public void setFail(TrieNode f) {
		this.fail = f;
	}

	public void addResult(String result) {
		this.results.add(result);
	}

	public Collection<String> getResults() {
		return this.results;
	}

}
