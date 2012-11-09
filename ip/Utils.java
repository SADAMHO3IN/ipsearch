/*
* LumaQQ - Java QQ Client
*
* Copyright (C) 2004 luma <stubma@163.com>
*                    notXX
*
* This program is free software; you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation; either version 2 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
*/
package ip;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.StringTokenizer;


/**
 * �����࣬�ṩһЩ����ķ�������Щ��Ҫ�����ڵ�����;����Щ����
 *
 * @author �����
 * @author notXX
 */
public class Utils {
    private static Random random;
    
	/**
	 * ���ֽ������offset��ʼ��len���ֽ�ת����һ��unsigned int�� ��Ϊjava����û��unsigned������unsigned
	 * intʹ��long��ʾ�ģ� ���len����8������Ϊlen����8�����lenС��8�����λ��0 <br>
	 * (edited by notxx) �ı����㷨, ������΢��һ��. ���ҵĻ����ϲ���10000��, ԭʼ�㷨����18s, ����㷨����12s.
	 * 
	 * @param in
	 *                   �ֽ�����.
	 * @param offset
	 *                   �����￪ʼת��.
	 * @param len
	 *                   ת������, ���len����8����Ժ����
	 * @return
	 */
	public static long getUnsignedInt(byte[] in, int offset, int len) {
		long ret = 0;
		int end = 0;
		if (len > 8)
			end = offset + 8;
		else
			end = offset + len;
		for (int i = offset; i < end; i++) {
			ret <<= 8;
			ret |= in[i] & 0xff;
		}
		return (ret & 0xffffffffl) | (ret >>> 32);
	}
    
    /**
     * �Ը�����byte������һ��MD5������QQ2003��ʼ����������MD5�ķ���
     * @param pwd ��Ҫ���ܵ������ֽ�����
     * @return �Ѿ����ܵ������ֽ�����
     */
    public static byte[] doMD5(byte[] pwd) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
        }
        md.update(pwd);
        return md.digest();
    }
    
    /**
     * ����յ����ļ�MD5�Ƿ���ȷ
     * @param file �յ��Ĵ��ڱ��ص��ļ�
     * @param md5 ��ȷ��MD5
     * @return true��ʾ��ȷ
     */
    public static boolean checkFileMD5(RandomAccessFile file, byte[] md5) {
        return compareMD5(getFileMD5(file), md5);
    }
    
    /**
     * ����յ����ļ�MD5�Ƿ���ȷ
     * @param filename
     * @param md5
     * @return
     */
    public static boolean checkFileMD5(String filename, byte[] md5) {
        return compareMD5(getFileMD5(filename), md5);
    }
    
    /**
     * �����ļ���MD5�����ֻ����ǰ��10002432�ֽ�
     * @param filename
     * @return
     */
    public static byte[] getFileMD5(String filename) {
        try {
            RandomAccessFile file = new RandomAccessFile(filename, "r");
            byte[] md5 =  getFileMD5(file);
            file.close();
            return md5;
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * �����ļ���MD5�����ֻ����ǰ��10002432�ֽ�
     * @param file RandomAccessFile����
     * @return MD5�ֽ�����
     */
    public static byte[] getFileMD5(RandomAccessFile file) {
        try {
            file.seek(0);
            byte[] buf = (file.length() > QQ.QQ_MAX_FILE_MD5_LENGTH) ? new byte[QQ.QQ_MAX_FILE_MD5_LENGTH] : new byte[(int)file.length()];
            file.readFully(buf);
            return doMD5(buf);
        } catch (IOException e) {
            return null;
        }
    }
    
    /**
     * �õ�һ���ļ���MD5�ַ�����ʽ
     * @param filename �ļ���
     * @return MD5�ַ�����ʽ��Сд������������󣬷���null
     */
    public static String getFileMD5String(String filename) {
        byte[] md5 = getFileMD5(filename);
        if(md5 == null) return null;
        
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < md5.length; i++)
            sb.append(Integer.toHexString(md5[i] & 0xFF));
        return sb.toString().toLowerCase();
    }
    
    /**
     * �Ƚ�����MD5�Ƿ����
     * @param m1
     * @param m2
     * @return true��ʾ���
     */
    public static boolean compareMD5(byte[] m1, byte[] m2) {
        if(m1 == null || m2 == null) return true;
        for(int i = 0; i < 16; i++) {
            if(m1[i] != m2[i])
                return false;
        }
        return true;
    }
    
    /**
     * ����ĳ�ֱ��뷽ʽ�õ��ַ������ֽ�������ʽ
     * @param s �ַ���
     * @param encoding ���뷽ʽ
     * @return �ض����뷽ʽ���ֽ����飬���encoding��֧�֣�����һ��ȱʡ������ֽ�����
     */
    public static byte[] getBytes(String s, String encoding) {
        try {
            return s.getBytes(encoding);
        } catch (UnsupportedEncodingException e) {
            return s.getBytes();
        }
    }
    
    /**
     * ��ԭʼ�ַ������б���ת�������ʧ�ܣ�����ԭʼ���ַ���
     * @param s ԭʼ�ַ���
     * @param srcEncoding Դ���뷽ʽ
     * @param destEncoding Ŀ����뷽ʽ
     * @return ת���������ַ�����ʧ�ܷ���ԭʼ�ַ���
     */
    public static String getString(String s, String srcEncoding, String destEncoding) {
        try {
            return new String(s.getBytes(srcEncoding), destEncoding);
        } catch (UnsupportedEncodingException e) {
            return s;
        }
    }
    
    /**
     * ����ĳ�ֱ��뷽ʽ���ֽ�����ת�����ַ���
     * @param b �ֽ�����
     * @param encoding ���뷽ʽ
     * @return ���encoding��֧�֣�����һ��ȱʡ������ַ���
     */
    public static String getString(byte[] b, String encoding) {
        try {
            return new String(b, encoding);
        } catch (UnsupportedEncodingException e) {
            return new String(b);
        }
    }
    
    /**
     * ����ĳ�ֱ��뷽ʽ���ֽ�����ת�����ַ���
     * @param b �ֽ�����
     * @param offset Ҫת������ʼλ��
     * @param len Ҫת���ĳ���
     * @param encoding ���뷽ʽ
     * @return ���encoding��֧�֣�����һ��ȱʡ������ַ���
     */
    public static String getString(byte[] b, int offset, int len, String encoding) {
        try {
            return new String(b, offset, len, encoding);
        } catch (UnsupportedEncodingException e) {
            return new String(b, offset, len);
        }
    }
    
    /**
     * ���ַ���ת����int
     * @param s �ַ���
     * @param faultValue ���ת��ʧ�ܣ��������ֵ
     * @return ���ת��ʧ�ܣ�����faultValue���ɹ�����ת�����ֵ
     */
    public static int getInt(String s, int faultValue) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return faultValue;
        }
    }
    
    /**
     * ���ַ���ת����Integer
     * @param s �ַ���
     * @param faultValue ���ת��ʧ�ܣ����ص������ֵ��Integer����
     * @return ���ת��ʧ�ܣ�����faultValue���ɹ�����ת�����ֵ
     */
    public static Integer getInteger(String s, int faultValue) {
        try {
            return new Integer(s);
        } catch (NumberFormatException e) {
            return new Integer(faultValue);
        }
    }
    
    /**
     * ���ַ���ת����Integer
     * @param s �ַ���
     * @param faultValue ���ת��ʧ�ܣ��������Integer����
     * @return ���ת��ʧ�ܣ�����faultValue���ɹ�����ת�����ֵ
     */
    public static Integer getInteger(String s, Integer faultValue) {
        try {
            return new Integer(s);
        } catch (NumberFormatException e) {
            return faultValue;
        }
    }
    
    /**
     * ���ַ���ת����char���͵��޷�����
     * @param s �ַ���
     * @param faultValue ���ת��ʧ�ܣ��������ֵ
     * @return ���ת��ʧ�ܣ�����faultValue���ɹ�����ת�����ֵ
     */
    public static char getChar(String s, int faultValue) {
        return (char)(getInt(s, faultValue) & 0xFFFF);
    }
    
    /**
     * ���ַ���ת����byte
     * @param s �ַ���
     * @param faultValue ���ת��ʧ�ܣ��������ֵ
     * @return ���ת��ʧ�ܣ�����faultValue���ɹ�����ת�����ֵ
     */
    public static byte getByte(String s, int faultValue) {
        return (byte)(getInt(s, faultValue) & 0xFF);
    }
    
    /**
     * @param ip ip���ֽ�������ʽ
     * @return �ַ�����ʽ��ip
     */
    public static String getIpStringFromBytes(byte[] ip) {
    	StringBuffer sb = new StringBuffer();
    	sb.append(ip[0] & 0xFF);
    	sb.append('.');   	
    	sb.append(ip[1] & 0xFF);
    	sb.append('.');   	
    	sb.append(ip[2] & 0xFF);
    	sb.append('.');   	
    	sb.append(ip[3] & 0xFF);
    	return sb.toString();
    }
    
    /**
     * ��ip���ַ�����ʽ�õ��ֽ�������ʽ
     * @param ip �ַ�����ʽ��ip
     * @return �ֽ�������ʽ��ip
     */
    public static byte[] getIpByteArrayFromString(String ip) {
        byte[] ret = new byte[4];
        StringTokenizer st = new StringTokenizer(ip, ".");
        try {
            ret[0] = (byte)(Integer.parseInt(st.nextToken()) & 0xFF);
            ret[1] = (byte)(Integer.parseInt(st.nextToken()) & 0xFF);
            ret[2] = (byte)(Integer.parseInt(st.nextToken()) & 0xFF);
            ret[3] = (byte)(Integer.parseInt(st.nextToken()) & 0xFF);
        } catch (Exception e) {
        }
        return ret;
    }
    
    /**
     * �ж�IP�Ƿ����
     * @param ip1 IP���ֽ�������ʽ
     * @param ip2 IP���ֽ�������ʽ
     * @return true�������IP���
     */
    public static boolean isIpEquals(byte[] ip1, byte[] ip2) {
        return (ip1[0] == ip2[0] && ip1[1] == ip2[1] && ip1[2] == ip2[2] && ip1[3] == ip2[3]);
    }
    
    /**
     * @param cmd ��������
     * @return ������ַ�����ʽ�����ڵ���
     */
    public static String getCommandString(char cmd) {
        switch (cmd) {
	        case QQ.QQ_CMD_LOGOUT:
	            return "QQ.QQ_CMD_LOGOUT";
	        case QQ.QQ_CMD_KEEP_ALIVE:
	            return "QQ.QQ_CMD_KEEP_ALIVE";
	        case QQ.QQ_CMD_MODIFY_INFO:
	            return "QQ.QQ_CMD_MODIFY_INFO";
	        case QQ.QQ_CMD_SEARCH_USER:
	            return "QQ.QQ_CMD_SEARCH_USER";
	        case QQ.QQ_CMD_GET_USER_INFO:
	            return "QQ.QQ_CMD_GET_USER_INFO";
	        case QQ.QQ_CMD_ADD_FRIEND:
	            return "QQ.QQ_CMD_ADD_FRIEND";
	        case QQ.QQ_CMD_DELETE_FRIEND:
	            return "QQ.QQ_CMD_DELETE_FRIEND";
	        case QQ.QQ_CMD_ADD_FRIEND_AUTH:
	            return "QQ.QQ_CMD_ADD_FRIEND_AUTH";
	        case QQ.QQ_CMD_CHANGE_STATUS:
	            return "QQ.QQ_CMD_CHANGE_STATUS";
	        case QQ.QQ_CMD_ACK_SYS_MSG:
	            return "QQ.QQ_CMD_ACK_SYS_MSG";
	        case QQ.QQ_CMD_SEND_IM:
	            return "QQ.QQ_CMD_SEND_IM";
	        case QQ.QQ_CMD_RECV_IM:
	            return "QQ.QQ_CMD_RECV_IM";
	        case QQ.QQ_CMD_REMOVE_SELF:
	            return "QQ.QQ_CMD_REMOVE_SELF";
	        case QQ.QQ_CMD_LOGIN:
	            return "QQ.QQ_CMD_LOGIN";
	        case QQ.QQ_CMD_GET_FRIEND_LIST:
	            return "QQ.QQ_CMD_GET_FRIEND_LIST";
	        case QQ.QQ_CMD_GET_FRIEND_ONLINE:
	            return "QQ.QQ_CMD_GET_FRIEND_ONLINE";
	        case QQ.QQ_CMD_CLUSTER_CMD:
	            return "QQ.QQ_CMD_CLUSTER_CMD";
	        case QQ.QQ_CMD_RECV_MSG_SYS:
	            return "QQ.QQ_CMD_RECV_MSG_SYS";
	        case QQ.QQ_CMD_RECV_MSG_FRIEND_CHANGE_STATUS:
	            return "QQ.QQ_CMD_RECV_MSG_FRIEND_CHANGE_STATUS";
	        case QQ.QQ_CMD_REQUEST_KEY:
	            return "QQ_CMD_REQUEST_KEY";
	        case QQ.QQ_CMD_GROUP_NAME_OP:
	        	return "QQ_CMD_GROUP_NAME_OP";
	        case QQ.QQ_CMD_UPLOAD_GROUP_FRIEND:
	        	return "QQ_CMD_UPLOAD_GROUP_FRIEND";
	        case QQ.QQ_CMD_DOWNLOAD_GROUP_FRIEND:
	        	return "QQ_CMD_DOWNLOAD_GROUP_FRIEND";
	        case QQ.QQ_CMD_FRIEND_REMARK_OP:
	        	return "QQ_CMD_FRIEND_REMARK_OP";
	        default:
	            return "UNKNOWN_TYPE " + (int)cmd;
        }
    }
    
    /**
     * �õ�Ⱥ�������ַ�����ʽ�������ڵ���
     * @param cmd
     * @return
     */
    public static String getClusterCommandString(byte cmd) {
    	  switch (cmd) {
    	    case QQ.QQ_CLUSTER_CMD_CREATE_CLUSTER:
    	    	return "QQ_CLUSTER_CMD_CREATE_CLUSTER";
    	    case QQ.QQ_CLUSTER_CMD_MEMBER_OPT:
    	    	return "QQ_CLUSTER_CMD_MEMBER_OPT";
    	    case QQ.QQ_CLUSTER_CMD_MODIFY_CLUSTER_INFO:
    	    	return "QQ_CLUSTER_CMD_MODIFY_CLUSTER_INFO";
    	    case QQ.QQ_CLUSTER_CMD_GET_CLUSTER_INFO:   
    	    	return "QQ_CLUSTER_CMD_GET_CLUSTER_INFO";
    	    case QQ.QQ_CLUSTER_CMD_ACTIVATE_CLUSTER:    
    	    	return "QQ_CLUSTER_CMD_ACTIVATE_CLUSTER";
    	    case QQ.QQ_CLUSTER_CMD_SEARCH_CLUSTER:     
    	    	return "QQ_CLUSTER_CMD_SEARCH_CLUSTER";
    	    case QQ.QQ_CLUSTER_CMD_JOIN_CLUSTER:        
    	    	return "QQ_CLUSTER_CMD_JOIN_CLUSTER";
    	    case QQ.QQ_CLUSTER_CMD_JOIN_CLUSTER_AUTH:   
    	    	return "QQ_CLUSTER_CMD_JOIN_CLUSTER_AUTH";
    	    case QQ.QQ_CLUSTER_CMD_EXIT_CLUSTER:        
    	    	return "QQ_CLUSTER_CMD_EXIT_CLUSTER";
    	    case QQ.QQ_CLUSTER_CMD_SEND_IM:          
    	    	return "QQ_CLUSTER_CMD_SEND_IM";
    	    case QQ.QQ_CLUSTER_CMD_GET_ONLINE_MEMBER: 
    	    	return "QQ_CLUSTER_CMD_GET_ONLINE_MEMBER";
    	    case QQ.QQ_CLUSTER_CMD_GET_MEMBER_INFO:  
    	    	return "QQ_CLUSTER_CMD_GET_MEMBER_INFO";
    	    default:                             
    	    	return "Unknown QQ Group Command";
    	  }
    }
    
    /**
     * �����ļ�������ַ�����ʽ������������
     * @param command
     * @return
     */
    public static String getFileCommandString(char command) {
    	switch(command) {
    	    case QQ.QQ_FILE_CMD_HEART_BEAT:
    	        return "QQ_FILE_CMD_HEART_BEAT";
    	    case QQ.QQ_FILE_CMD_HEART_BEAT_ACK:
    	        return "QQ_FILE_CMD_HEART_BEAT_ACK";
    	    case QQ.QQ_FILE_CMD_TRANSFER_FINISHED:
    	        return "QQ_FILE_CMD_TRANSFER_FINISHED";
    	    case QQ.QQ_FILE_CMD_FILE_OP:
    	        return "QQ_FILE_CMD_FILE_OP";
    	    case QQ.QQ_FILE_CMD_FILE_OP_ACK:
    	        return "QQ_FILE_CMD_FILE_OP_ACK";
    		case QQ.QQ_FILE_CMD_SENDER_SAY_HELLO:
    			return "QQ_FILE_CMD_SENDER_SAY_HELLO";    	
    		case QQ.QQ_FILE_CMD_SENDER_SAY_HELLO_ACK:
    		    return "QQ_FILE_CMD_SENDER_SAY_HELLO_ACK";
    		case QQ.QQ_FILE_CMD_RECEIVER_SAY_HELLO:
    			return "QQ_FILE_CMD_RECEIVER_SAY_HELLO";    		
    		case QQ.QQ_FILE_CMD_RECEIVER_SAY_HELLO_ACK:
    			return "QQ_FILE_CMD_RECEIVER_SAY_HELLO_ACK";    		
    		case QQ.QQ_FILE_CMD_NOTIFY_IP_ACK:
    			return "QQ_FILE_CMD_NOTIFY_IP_ACK";    		
    		case QQ.QQ_FILE_CMD_PING:
    			return "QQ_FILE_CMD_PING";    		
    		case QQ.QQ_FILE_CMD_PONG:
    			return "QQ_FILE_CMD_PONG";    		
    		case QQ.QQ_FILE_CMD_YES_I_AM_BEHIND_FIREWALL:
    			return "QQ_FILE_CMD_YES_I_AM_BEHIND_FIREWALL";    			
    		default:
    			return "UNKNOWN TYPE " + (int)command;
    	}
    }
    
    /**
     * @param clientTag �ͻ��˱�ʶ
     * @return �ͻ��˱�ʶ���ַ�����ʽ�����ڵ���
     */
    public static String getClientString(char clientTag) {
        switch (clientTag) {
	        case QQ.QQ_CLIENT_062E:
	            return "GB QQ2000c build 630";
	        case QQ.QQ_CLIENT_072E:
	            return "En QQ2000c build 305";
	        case QQ.QQ_CLIENT_0801:
	            return "En QQ2000c build 630";
	        case QQ.QQ_CLIENT_0A1D:
	            return "GB QQ2003c build 0808";
	        case QQ.QQ_CLIENT_0B07:
	            return "GB QQ2003c build 0925";
	        case QQ.QQ_CLIENT_0B2F:
	            return "GB QQ2003iii build 0117";
	        case QQ.QQ_CLIENT_0B35:  
	            return "GB QQ2003iii build 0304";
	        case QQ.QQ_SERVER_0100:
	            return "QQ Server 0100";
	        default:
	            return "QQ unknown version";
        }
    }
    
    /**
     * �õ�״̬���ַ�����ʾ
     * @param status ״̬��
     * @return �ַ�����ʽ��״̬��
     */
    public static String getStatusString(byte status) {
    	switch(status) {
    		case QQ.QQ_FRIEND_STATUS_ONLINE:
    			return "online";
    		case QQ.QQ_FRIEND_STATUS_OFFLINE:
    			return "offline";
    		case QQ.QQ_FRIEND_STATUS_AWAY:
    			return "away";
    		case QQ.QQ_FRIEND_STATUS_HIDDEN:
    			return "hidden";
    		default:
    			return "Unknown Status";
    	}
    }
    
    /**
     * ����������ڵ��Եģ�����Ҫ�õķ���
     * @param encoding ���뷽ʽ
     * @return ���뷽ʽ���ַ�����ʾ��ʽ
     */
    public static String getEncodingString(char encoding) {
        switch(encoding) {
        	case QQ.QQ_IM_ENCODING_GB:
        	    return "GBK";
        	case QQ.QQ_IM_ENCODING_EN:
        	    return "ISO-8859-1";
        	case QQ.QQ_IM_ENCODING_BIG5:
        	    return "BIG5";
        	default:
        	    return "GBK";
        }
    }
    
    /**
     * ���ڵ���
     * @param type �յ�����Ϣ����
     * @return ��Ϣ���͵��ַ�����ʾ
     */
    public static String getIMTypeString(char type) {
        switch (type) {
	        case QQ.QQ_RECV_IM_TO_BUDDY:
	            return "QQ_RECV_IM_TO_BUDDY";
	        case QQ.QQ_RECV_IM_TO_UNKNOWN:
	            return "QQ_RECV_IM_TO_UNKNOWN";
	        case QQ.QQ_RECV_IM_CLUSTER_IM:
	            return "QQ_RECV_IM_CLUSTER_IM";
	        case QQ.QQ_RECV_IM_ADDED_TO_CLUSTER:
	            return "QQ_RECV_IM_ADDED_TO_CLUSTER";
	        case QQ.QQ_RECV_IM_DELETED_FROM_CLUSTER:
	            return "QQ_RECV_IM_DEL_FROM_CLUSTER";
	        case QQ.QQ_RECV_IM_REQUEST_JOIN_CLUSTER:
	            return "QQ_RECV_IM_REQUEST_JOIN_CLUSTER";
	        case QQ.QQ_RECV_IM_CREATE_CLUSTER:
	            return "QQ_RECV_IM_CREATE_CLUSTER";
	        case QQ.QQ_RECV_IM_SYS_MESSAGE:
	            return "QQ_RECV_IM_SYS_MESSAGE";
	        case QQ.QQ_RECV_IM_APPROVE_JOIN_CLUSTER:
	            return "QQ_RECV_IM_APPROVE_JOIN_CLUSTER";
	        case QQ.QQ_RECV_IM_REJECT_JOIN_CLUSTER:
	            return "QQ_RECV_IM_REJECT_JOIN_CLUSTER";
	        default:
	            return "QQ_RECV_IM_UNKNOWN";
        }
    }
    
    /**
     * ������ͨ��Ϣ�е����ͣ�����������
     * @param type
     * @return
     */
    public static String getNormalIMTypeString(char type) {
        switch(type) {
            case QQ.QQ_IM_NORMAL_TEXT:
                return "QQ_IM_NORMAL_TEXT";
            case QQ.QQ_IM_TCP_REQUEST:
                return "QQ_IM_TCP_REQUEST";
            case QQ.QQ_IM_ACCEPT_TCP_REQUEST:
                return "QQ_IM_ACCEPT_TCP_REQUEST";
            case QQ.QQ_IM_REJECT_TCP_REQUEST:
                return "QQ_IM_REJECT_TCP_REQUEST";
            case QQ.QQ_IM_UDP_REQUEST:
                return "QQ_IM_UDP_REQUEST";
            case QQ.QQ_IM_ACCEPT_UDP_REQUEST:
                return "QQ_IM_ACCEPT_UDP_REQUEST";
            case QQ.QQ_IM_REJECT_UDP_REQUEST:
                return "QQ_IM_REJECT_UDP_REQUEST";
            case QQ.QQ_IM_NOTIFY_IP:
                return "QQ_IM_NOTIFY_IP";
            case QQ.QQ_IM_ARE_YOU_BEHIND_FIREWALL:
                return "QQ_IM_ARE_YOU_BEHIND_FIREWALL";
            case QQ.QQ_IM_ARE_YOU_BEHIND_PROXY:
                return "QQ_IM_ARE_YOU_BEHIND_PROXY";
            case QQ.QQ_IM_YES_I_AM_BEHIND_PROXY:
                return "QQ_IM_YES_I_AM_BEHIND_PROXY";
            case QQ.QQ_IM_REQUEST_CANCELED:
                return "QQ_IM_REQUEST_CANCELED";
            default:
                return String.valueOf((int)type);
        }
    }
    
    /**
     * �����ַ�����ʽ�Ļظ����ͣ������ڵ���
     * @param type �ظ�����
     * @return �ַ�����ʽ�Ļظ�����
     */
    public static String getIMReplyType(byte type) {
        switch(type) {
        	case QQ.QQ_IM_NORMAL_REPLY:
        	    return "QQ_IM_TEXT";
        	case QQ.QQ_IM_AUTO_REPLY:
        	    return "QQ_IM_AUTO_REPLY";
        	default:
        	    return "UNKNOWN";
        }
    }
    
    /**
     * ��buf�ֽ������е�beginλ�ÿ�ʼ�������ֽ�b���ֵĵ�һ��λ��
     * @param buf �ֽ�����
     * @param begin ��ʼδ֪����
     * @param b Ҫ���ҵ��ֽ�
     * @return �ҵ��򷵻����������򷵻�-1
     */
    public static int indexOf(byte[] buf, int begin, byte b) {
    	for(int i = begin; i < buf.length; i++) {
    		if(buf[i] == b)
    			return i;
    	}
    	return -1;
    }
    
    /**
     * ��buf�ֽ������е�beginλ�ÿ�ʼ�������ֽ�����b��ֻҪ�κ�һ�����ֵĵ�һ��λ��
     * @param buf �ֽ�����
     * @param begin ��ʼδ֪����
     * @param b Ҫ���ҵ��ֽ�����
     * @return �ҵ��򷵻����������򷵻�-1
     */
    public static int indexOf(byte[] buf, int begin, byte[] b) {
    	for(int i = begin; i < buf.length; i++) {
    		for(int j = 0; j < b.length; j++)
	    		if(buf[i] == b[j])
	    			return i;
    	}
    	return -1;
    }
    
	/**
	 * @return Random����
	 */
	public static Random random() {
		if (random == null)
			random = new Random();
		return random;
	}

	/**
	 * ��content��offsetλ�����4���ֽڽ�����int����
	 * @param content �ֽ�����
	 * @param offset ƫ��
	 * @return int
	 */
	public static final int parseInt(byte[] content, int offset) {
		return ((content[offset++] & 0xff) << 24) | ((content[offset++] & 0xff) << 16) | ((content[offset++] & 0xff) << 8) | (content[offset++] & 0xff);
	}

	/**
	 * ��content��offsetλ�����2���ֽڽ�����char����
	 * @param content �ֽ�����
	 * @param offset ƫ��
	 * @return char
	 */
	public static final char parseChar(byte[] content, int offset) {
		return (char) (((content[offset++] & 0xff) << 8) | (content[offset++] & 0xff));
	}
}
