package com.classify;

/**
 * �ؼ��ֵĲ��ҡ��滻��ͳ�ƹ��ܡ�
 * 
 * <pre>
 * �����÷����£�
 * <code>
 *   KeywordFilterBuilder builder = new KeywordFilterBuilder();
 *   // ���ùؼ���
 *   builder.setKeywords(Arrays.asList("����", "����"));
 *   // ���������ַ�
 *   builder.setSkipChars(Arrays.asList('*', ' '));
 *   final KeywordFilter filter = builder.build();
 *   
 *   // ͳ�ƹؼ��ֳ��ִ���, �����з���2. 
 *   filter.count("������ŭ����ũ����ũ��ŭ��������", "����");
 *   filter.count("��*����ŭ����ũ����ũ��ŭ���� ����", "����");
 *   
 *   // �滻�ؼ���, �����з���"���Ʊ�н��ˣ��Ǻ�".
 *   filter.replace("���Ʊ�н��ˣ�����", new ReplaceStrategy() {
 *   	public String replaceWith(String keywords) {
 *  		return "�Ǻ�";
 *  	}
 *   });
 *   
 *   // �ж��Ƿ�����ؼ���, �����з���true, ��Ϊ����"����".
 *   filter.hasKeywords("����������������Ҳ���ź�������")
 *   filter.hasKeywords("��������������*��Ҳ���ź�������")
 *   
 *  </code>
 * </pre>
 * 
 * �������Ӳμ�{@link TestKeywordFilter}
 * 
 * @author lianxh
 * @since 2013/12/14
 */
public interface KeywordFilter {

	/**
	 * �Ƿ����ָ���ؼ���
	 * 
	 * @param text
	 *            ��ƥ���ı�
	 * @return �����������true������false
	 */
	public boolean hasKeywords(String text);

	/**
	 * ͳ��ָ���ؼ��ֳ��ִ���.
	 * 
	 * @param text
	 *            ��ͳ�Ƶ��ı�
	 * @param keyword
	 *            �ؼ���
	 * @return �ؼ��ֳ��ִ���
	 */
	public int count(String text, String keyword);

	/**
	 * ����ָ�������滻�ؼ��֣�ʹ�ò�ͬ�Ĳ��Կ�ʵ�ָ������ܡ�
	 * 
	 * @param text
	 *            ��ƥ���ı�
	 * @param strategy
	 *            �滻����
	 * @return �滻��Ľ���ַ���
	 */
	public String replace(String text, ReplaceStrategy strategy);

}
