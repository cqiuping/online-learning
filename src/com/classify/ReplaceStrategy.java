package com.classify;
/**
 * �ؼ����滻���ԡ�
 */
public interface ReplaceStrategy {

	/**
	 * ���ؼ����滻Ϊ�����Ľ���ַ���
	 * 
	 * @param keyword
	 *            keyword
	 * @return The resulting <tt>String</tt>
	 */
	String replaceWith(String keyword);

}
