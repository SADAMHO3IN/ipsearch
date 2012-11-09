/*
 * 2004-9-1
 * Terry
 */
package ip;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * i18n
 * 
 * @author terry
 */
public class I18n {

	private static ResourceBundle resourceBundle;

	public I18n (String baseName, Locale locale, ClassLoader classloader) {
		resourceBundle = ResourceBundle.getBundle(baseName, locale, classloader);
	}

	/**
	 * ����Դ�ļ��з����ַ��� ���ǲ�ϣ������������������û���ҵ�Key����ֱ�ӷ���Key
	 * 
	 * @param key
	 * @return ��Դ
	 */
	public static String getResourceString (String key) {
		try {
			return resourceBundle.getString(key);
		}
		catch (MissingResourceException e) {
			return key;
		}
		catch (NullPointerException e) {
			return "!" + key + "!";
		}
	}
}