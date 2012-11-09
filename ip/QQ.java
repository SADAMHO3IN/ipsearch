package ip;

/**
 * ����һЩQQ�õ��ĳ���
 *
 * @author �����
 */
public interface QQ {    
	/** QQ UDP����ͷ���ֽڳ��� */
    public static final int QQ_UDP_HEADER_LENGTH = 7;
	/** QQ TCP����ͷ���ֽڳ��� */
    public static final int QQ_TCP_HEADER_LENGTH = 9;
	/** QQ����β���ֽڳ� */
    public static final int QQ_TAIL_LENGTH = 1;
    
    /** �������� - �޴��� */
    public static final int PROXY_NONE = 0;
    /** �������� - Socks5���� */
    public static final int PROXY_SOCKS5 = 1;
    /** �������� - Http���� */
    public static final int PROXY_HTTP = 2;
    
	/** ����Ҫȷ�ϵİ��ķ��ʹ��������ֵӦ�������ģ�����QQ Logout������4�Σ�������ѡ4 */ 
    public static final int QQ_ACK_PACKET_SEND_TIME = 4;

	/** �ʼ��½ʱ���͵ĳ�ʼ��Կ���������ܵ�½��Ϣ */
    public static byte[] iniKey = new byte[] {
        0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01,
      	0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01
    };
	/** QQ��½�����е�23�ֽڵ�51�ֽڵĹ̶����� */
    public static byte[] login_23_51 = new byte[] {
    	0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
    	0x00, 0x00, 0x00, 0x00, (byte)0xBF, 0x14, 0x11, 0x20,
    	0x03, (byte)0x9D, (byte)0xB2, (byte)0xE6, (byte)0xB3, 0x11, (byte)0xB7, 0x13,
    	(byte)0x95, 0x67, (byte)0xDA, 0x2C, 0x01 
    };
	/** QQ��½�����е�53�ֽڵ�68�ֽڵĹ̶����� */
    public static byte[] login_53_68 = new byte[] {
        (byte)0x82, 0x2A, (byte)0x91, (byte)0xFD, (byte)0xA5, (byte)0xCA, 0x67, 0x4C,
        (byte)0xAC, (byte)0x81, 0x1F, 0x6F, 0x52, 0x05, (byte)0xA7, (byte)0xBF
    };  
    
	/** ������С */
	public static final int MAX_PACKET_SIZE = 65535;
	/** ��Ϣ��󳤶� */
	public static final int MAX_SEND_IM_SIZE = 400;
	/** ��Կ���� */
	public static final int QQ_KEY_LENGTH = 16;
	/** ��½��Ϣ���� */
	public static final int QQ_LOGIN_DATA_LENGTH = 69;
    
	/** QQ UDPȱʡ�˿� */
	public static final int QQ_UDP_PORT = 8000;
	/** QQ TCPȱʡ�˿� */
	public static final int QQ_TCP_PORT = 80;
	/** ʹ��HTTP����ʱ����QQ�������Ķ˿� */
	public static final int QQ_HTTP_PORT = 443;
	   
    /** QQȱʡ���뷽ʽ */
	public static final String QQ_CHARSET_DEFAULT = "GBK";
	/** ��Ϣ���룬��������Լ����Ҷ��� */
	public static final char QQ_IM_ENCODING_GB = 0x8602;
	public static final char QQ_IM_ENCODING_EN = 0x0000;	
	public static final char QQ_IM_ENCODING_BIG5 = 0x8603;
	
	/** ��λ: ms */
	public static final long QQ_SENDQUEUE_TIMEOUT = 5000;
	/** ����ط����� */
	public static final int QQ_RESEND_MAX = 5;
	/** Keep Alive�����ͼ������λ: ms */
	public static final long QQ_KEEP_ALIVE_INTERVAL = 60000;

	/** QQ�������������ֽڳ��ȣ�ע��һ�������������ֽ� */
	public static final int QQ_MAX_GROUP_NAME_BYTE = 16;
	/** QQ�ǳƵ������ */
	public static final int QQ_NAME_LENGTH_MAX = 250;
	/** QQ��Ϣ������� */
	public static final int QQ_MSG_IM_MAX = 1500;
	/** QQȱʡ������� */
	public static final int QQ_SMILEY_AMOUNT = 96;
	/** �û�����Ϣ���ֶθ��� */
	public static final int QQ_CONTACT_FIELDS = 37;
	/** �û���ע��Ϣ���ֶθ��� */
	public static final int QQ_REMARK_FIELDS = 7;
	
	/** �ͻ��˰汾�ű�־-client GB QQ2000c build 630 */
	public static final char QQ_CLIENT_062E = 0x062E;
	/** �ͻ��˰汾�ű�־-client En QQ2000c build 305 */
	public static final char QQ_CLIENT_072E = 0x072E;
	/** �ͻ��˰汾�ű�־-client En QQ2000c build 630 */
	public static final char QQ_CLIENT_0801 = 0x0801;
	/** �ͻ��˰汾�ű�־-client Gb QQ2003c build 0808 */
	public static final char QQ_CLIENT_0A1D = 0x0A1D;
	/** �ͻ��˰汾�ű�־-client Gb QQ2003c build 0925 */
	public static final char QQ_CLIENT_0B07 = 0x0B07;
	/** �ͻ��˰汾�ű�־-client GB QQ2003iii build 0117 */
	public static final char QQ_CLIENT_0B2F = 0x0B2f;
	/** �ͻ��˰汾�ű�־-GB QQ2003iii build 0304 (offical release) */
	public static final char QQ_CLIENT_0B35 = 0x0B35;
	/** �ͻ��˰汾�ű�־-QQ20003 III ��ʾ���������������� */
	public static final char QQ_CLIENT_0B37 = 0x0B37;
	/** �ͻ��˰汾�ű�־-QQ2004 ��Ա�ڲ�� */
	public static final char QQ_CLIENT_0C0B = 0x0C0B;
	/** �ͻ��˰汾�ű�־-QQ2004 Ԥ���� */
	public static final char QQ_CLIENT_0C0D = 0x0C0D;
	/** �ͻ��˰汾�ű�־-server */
	public static final char QQ_SERVER_0100 = 0x0100;
	
	/** ����ȱʡʹ�õĿͻ��˰汾�� */
	public static final char QQ_CLIENT = QQ_CLIENT_0B37;
	
	/** ����QQ����ͨ��;����Ϣ����ͷ�ֽ� */
	public static final byte QQ_PACKET_TAG = 0x02;
	/** �����ļ�����ʱ�Ŀ�����Ϣ����ͷ�ֽ� */
	public static final byte QQ_FILE_CONTROL_PACKET_TAG = 0x00;
	/** �����ļ�����ʱ��������Ϣ����ͷ�ֽ� */
	public static final byte QQ_FILE_DATA_PACKET_TAG = 0x03;
    /** �����ļ���ת���Ŀ�ͷ�ֽ� */
	public static final byte QQ_FILE_AGENT_PACKET_TAG = 0x4;	
	/** �����QQ��ͨ��;��Ϣ����β���ֽ� */
	public static final byte QQ_PACKET_TAIL = 0x03;
		
	/** ������½ */
	public static final byte QQ_LOGIN_MODE_NORMAL = 0x0A;
	/** �����½ */
	public static final byte QQ_LOGIN_MODE_HIDDEN = 0x28;
	/** �Ա�-�� */
	public static final byte QQ_FRIEND_GENDER_GG = 0x0;
	/** �Ա�-Ů */
	public static final byte QQ_FRIEND_GENDER_MM = 0x1;
	/** �Ա�-δ֪ */
	public static final byte QQ_FRIEND_GENDER_UNKNOWN = (byte) 0xFF;
	
	/** ��־-QQ��Ա */
	public static final byte QQ_FRIEND_FLAG_QQ_MEMBER = 0x01;
	/** ��־-�ֻ� */
	public static final byte QQ_FRIEND_FLAG_MOBILE = 0x10;
	/** ��־-�ֻ��� */
	public static final byte QQ_FRIEND_FLAG_BIND_MOBILE = 0x20;
	
	/** ����״̬-���� */
	public static final byte QQ_FRIEND_STATUS_ONLINE = 10;
	/** ����״̬-���� */
	public static final byte QQ_FRIEND_STATUS_OFFLINE = 20;
	/** ����״̬-�뿪 */
	public static final byte QQ_FRIEND_STATUS_AWAY = 30;
	/** ����״̬-���� */
	public static final byte QQ_FRIEND_STATUS_HIDDEN = 40;

	/** �Ƿ�������ͷ(������������ͷ����) */
	public static final int QQ_MISC_STATUS_HAVING_VIDEO = 0x00000001;
	
	/** ��¼��Ϣ-�ɹ� */
	public static final byte QQ_LOGIN_REPLY_OK = 0x00;
	/** ��¼��Ϣ-�ض��� */
	public static final byte QQ_LOGIN_REPLY_REDIRECT = 0x01;
	/** ��¼��Ϣ-������� */
	public static final byte QQ_LOGIN_REPLY_PWD_ERROR = 0x02;
	/** ��¼��Ϣ-�������� */
	public static final byte QQ_LOGIN_REPLY_MISC_ERROR = 0x03;
	/** ���غ��ѷ���ɹ� */
	public static final byte QQ_UPLOAD_GROUP_FRIEND_OK = 0x00;
	/** ���غ��ѱ�ע�ɹ� */
	public static final byte QQ_UPLOAD_FRIEND_REMARK_OK = 0x00;
	/** �ı�����״̬�ɹ� */
	public static final byte QQ_CHANGE_STATUS_REPLY_OK = 0x30;
	/** ������Ϣ�ɹ� */
	public static final byte QQ_SEND_IM_REPLY_OK = 0x00;
	/** ������֤��Ϣ�ɹ� */
	public static final byte QQ_ADD_FRIEND_AUTH_REPLY_OK = 0x30;
	/** ɾ�����ѳɹ� */
	public static final byte QQ_DELETE_FRIEND_REPLY_OK = 0x00;
	/** ���Լ��ӶԷ�������ɾ���ɹ� */
	public static final byte QQ_REMOVE_SELF_REPLY_OK = 0x00;
	/** �õ���Կ�ɹ� */
	public static final byte QQ_REQUEST_KEY_REPLY_OK = 0x00;

	/** �����б�ӵ�һ�����ѿ�ʼ */
	public static final char QQ_FRIEND_LIST_POSITION_START = 0x0000;
	/** �����б��Ѿ�ȫ���õ� */
	public static final char QQ_FRIEND_LIST_POSITION_END = 0xFFFF;
	/** ���ߺ����б�ӵ�һ�����ѿ�ʼ */
	public static final byte QQ_FRIEND_ONLINE_LIST_POSITION_START = 0x00;
	/** ���ߺ����б��Ѿ�ȫ���õ� */
	public static final byte QQ_FRIEND_ONLINE_LIST_POSITION_END = (byte)0xFF;	
	/** ���Եõ��ĺ����б����� */
	public static final byte QQ_FRIEND_LIST_UNSORTED = 0;
	/** �Եõ��ĺ����б����� */
	public static final byte QQ_FRIEND_LIST_SORTED = 1;
	
	/** ����� - �ǳ� */
	public static final char QQ_CMD_LOGOUT = 0x0001;
	/** ����� - ��������״̬ */
	public static final char QQ_CMD_KEEP_ALIVE = 0x0002;
	/** ����� - �޸��Լ�����Ϣ */
	public static final char QQ_CMD_MODIFY_INFO = 0x0004;
	/** ����� - �����û� */
	public static final char QQ_CMD_SEARCH_USER = 0x0005;
	/** ����� - �õ�������Ϣ */
	public static final char QQ_CMD_GET_USER_INFO = 0x0006;
	/** ����� - ���һ������ */
	public static final char QQ_CMD_ADD_FRIEND = 0x0009;
	/** ����� - ɾ��һ������ */
	public static final char QQ_CMD_DELETE_FRIEND = 0x000A;
	/** ����� - ������֤��Ϣ */
	public static final char QQ_CMD_ADD_FRIEND_AUTH = 0x000B;
	/** ����� - �ı��Լ�������״̬ */
	public static final char QQ_CMD_CHANGE_STATUS = 0x000D;
	/** ����� - ȷ���յ���ϵͳ��Ϣ */
	public static final char QQ_CMD_ACK_SYS_MSG = 0x0012;
	/** ����� - ������Ϣ */
	public static final char QQ_CMD_SEND_IM = 0x0016;
	/** ����� - ������Ϣ */
	public static final char QQ_CMD_RECV_IM = 0x0017;
	/** ����� - ���Լ��ӶԷ�����������ɾ�� */
	public static final char QQ_CMD_REMOVE_SELF = 0x001C;
	/** ����һЩ������Ҫ����Կ�������ļ���ת����ƵҲ�п��� */
	public static final char QQ_CMD_REQUEST_KEY = 0x001D;
	/** ����� - �绰�����������յ����ֻ���Ϣ����˼ */
	public static final char QQ_CMD_CELL_PHONE_1 = 0x0021;
	/** ����� - ��½ */
	public static final char QQ_CMD_LOGIN = 0x0022;
	/** ����� - �õ������б� */
	public static final char QQ_CMD_GET_FRIEND_LIST = 0x0026;
	/** ����� - �õ����ߺ����б� */
	public static final char QQ_CMD_GET_FRIEND_ONLINE = 0x0027;
	/** ����� - ���ǵ绰�� */
	public static final char QQ_CMD_CELL_PHONE_2 = 0x0029;
	/** ����� - Ⱥ������� */
	public static final char QQ_CMD_CLUSTER_CMD = 0x0030;
	/** ����� - �������� */
	public static final char QQ_CMD_TEST = 0x0031;
	/** ����� - �ϴ����غ��ѷ�������� */
	public static final char QQ_CMD_GROUP_NAME_OP = 0x003C;
	/** ����� - �ϴ������еĺ���QQ���б� */
	public static final char QQ_CMD_UPLOAD_GROUP_FRIEND = 0x003D;
	/** ����� - �ϴ����غ��ѱ�ע */
	public static final char QQ_CMD_FRIEND_REMARK_OP = 0x003E;
	/** ����� - ���ط����еĺ���QQ���б� */
	public static final char QQ_CMD_DOWNLOAD_GROUP_FRIEND = 0x0058;
	/** ����� - ���յ�ϵͳ��Ϣ */
	public static final char QQ_CMD_RECV_MSG_SYS = 0x0080;
	/** ����� - ���Ѹı�״̬ */
	public static final char QQ_CMD_RECV_MSG_FRIEND_CHANGE_STATUS = 0x0081;
	
	/** ������Կ���� - δ֪ */
	public static final byte QQ_REQUEST_UNKNOWN_KEY = 0x3;
	/** ������Կ���� - �ļ���ת��Կ */
	public static final byte QQ_REQUEST_FILE_AGENT_KEY = 0x4;
	
	/** Ⱥ�������� - ����Ⱥ */
	public static final byte QQ_CLUSTER_CMD_CREATE_CLUSTER		= 0x01;
	/** Ⱥ�������� - ��Աѡ���ʱδ�õ� */
	public static final byte QQ_CLUSTER_CMD_MEMBER_OPT			= 0x02;
	/** Ⱥ�������� - �޸�Ⱥ���� */
	public static final byte QQ_CLUSTER_CMD_MODIFY_CLUSTER_INFO	= 0x03;
	/** Ⱥ�������� - �õ�Ⱥ���� */
	public static final byte QQ_CLUSTER_CMD_GET_CLUSTER_INFO	= 0x04;
	/** Ⱥ�������� - ����Ⱥ */
	public static final byte QQ_CLUSTER_CMD_ACTIVATE_CLUSTER	= 0x05;
	/** Ⱥ�������� - ����Ⱥ */
	public static final byte QQ_CLUSTER_CMD_SEARCH_CLUSTER		= 0x06;
	/** Ⱥ�������� - ����Ⱥ */
	public static final byte QQ_CLUSTER_CMD_JOIN_CLUSTER		= 0x07;
	/** Ⱥ�������� - ����Ⱥ����֤��Ϣ */
	public static final byte QQ_CLUSTER_CMD_JOIN_CLUSTER_AUTH	= 0x08;
	/** Ⱥ�������� - �˳�Ⱥ */
	public static final byte QQ_CLUSTER_CMD_EXIT_CLUSTER		= 0x09;
	/** Ⱥ�������� - ����Ⱥ��Ϣ */
	public static final byte QQ_CLUSTER_CMD_SEND_IM				= 0x0A;
	/** Ⱥ�������� - �õ����߳�Ա */
	public static final byte QQ_CLUSTER_CMD_GET_ONLINE_MEMBER	= 0x0B;
	/** Ⱥ�������� - �õ���Ա���� */
	public static final byte QQ_CLUSTER_CMD_GET_MEMBER_INFO		= 0x0C;
	/** Ⱥ��������ظ� - �ɹ� */
	public static final byte QQ_CLUSTER_CMD_REPLY_OK					= 0x00;
	/** Ⱥ��������ظ� - ���������Ⱥ */
	public static final byte QQ_CLUSTER_CMD_REPLY_NO_SUCH_CLUSTER		= 0x02;
	/** Ⱥ��������ظ� - �㲻�Ǹ�Ⱥ�ĳ�Ա */
	public static final byte QQ_CLUSTER_CMD_REPLY_NOT_MEMBER			= 0x0a;
	/** Ⱥ���ͳ��� - �̶�Ⱥ */
	public static final byte QQ_CLUSTER_TYPE_PERMANENT = 0x01;
	/** Ⱥ���ͳ��� - ��ʱȺ */
	public static final byte QQ_CLUSTER_TYPE_TEMPORARY = 0x02;
	/** Ⱥ��֤���� - ������֤ */
	public static final byte QQ_CLUSTER_NO_AUTH		= 0x01;
	/** Ⱥ��֤���� - ��Ҫ��֤ */
	public static final byte QQ_CLUSTER_NEED_AUTH   = 0x02;
	/** Ⱥ��֤���� - �ܾ��κ��˼��� */
	public static final byte QQ_CLUSTER_NO_ADD  	= 0x03;
	/** Ⱥ��֤��Ϣ���� - �������Ⱥ */
	public static final byte QQ_CLUSTER_AUTH_REQUEST   = 0x01;
	/** Ⱥ��֤��Ϣ���� - ͬ�����Ⱥ */
	public static final byte QQ_CLUSTER_AUTH_APPROVE   = 0x02;
	/** Ⱥ��֤��Ϣ���� - �ܾ�����Ⱥ */
	public static final byte QQ_CLUSTER_AUTH_REJECT    = 0x03;
	/** ����Ⱥ�Ļظ��� - ����ɹ� */
	public static final byte QQ_CLUSTER_JOIN_OK			= 0x01;	
	/** ����Ⱥ�Ļظ��� - �Է���Ҫ��֤ */
	public static final byte QQ_CLUSTER_JOIN_NEED_AUTH	= 0x02;
	/** Ⱥ��������ʽ - ����Ⱥ������ */
	public static final byte QQ_SEARCH_CLUSTER_BY_ID 	= 0x01;
	/** Ⱥ��������ʽ - ����ʾ��Ⱥ */
	public static final byte QQ_SEARCH_DEMO_CLUSTER		= 0x02;
	  
	/** ��Ϣ�ظ����� - �����ظ� */
	public static final byte QQ_IM_NORMAL_REPLY = 0x01;
	/** ��Ϣ�ظ����� - �Զ��ظ� */
	public static final byte QQ_IM_AUTO_REPLY = 0x02;
	
	// ��Ϣ��Դ����Ҫ��MessageQueueʹ�ã���Э���ϵ����
	/** ���Ժ��� */
	public static final int QQ_IM_FROM_FRIEND = 0;
	/** ����ϵͳ */
	public static final int QQ_IM_FROM_SYS = 1;
	/** ����Ⱥ */
	public static final int QQ_IM_FROM_CLUSTER = 2;
	
	/** ������������ - �ϴ� */
	public static final byte QQ_UPLOAD_GROUP_NAME = 0x2;
	/** ������������ - ���� */
	public static final byte QQ_DOWNLOAD_GROUP_NAME = 0x1;
	
	/** ��ע�������� - �ϴ� */
	public static final byte QQ_UPLOAD_FRIEND_REMARK = 0x1;
	/** ��ע�������� - ���� */
	public static final byte QQ_DOWNLOAD_FRIEND_REMARK = 0x3;
	
	// �����������������غ��ѷ���ʱ
	/** �������� - �������һ���û� */
	public static final byte QQ_ID_IS_FRIEND = 0x1;
	/** �������� - ������һ��Ⱥ */
	public static final byte QQ_ID_IS_CLUSTER = 0x4;
	
	// ��Ϣ���ͣ�����ReceiveIMHeader�е����ͣ�������Щ���ͣ�������Ϊ֪ͨ������
	//    ��������ʾ����Ϣ�����У�����������룬��֤֮�����Ϣ
	/** ���Ժ��ѵ���Ϣ */
	public static final char QQ_RECV_IM_TO_BUDDY = 0x0009;
	/** ����İ���˵���Ϣ */
	public static final char QQ_RECV_IM_TO_UNKNOWN = 0x000A;
	/** ����Ⱥ����Ϣ */
	public static final char QQ_RECV_IM_CLUSTER_IM = 0x0020;
	/** ֪ͨ�ұ����뵽һ��Ⱥ�����Ⱥ��ǰ�Ѿ����������Ǻ������ӵ� */
	public static final char QQ_RECV_IM_ADDED_TO_CLUSTER = 0x0021;
	/** �ұ��߳�һ��Ⱥ */
	public static final char QQ_RECV_IM_DELETED_FROM_CLUSTER = 0x0022;
	/** �����������Ⱥ */
	public static final char QQ_RECV_IM_REQUEST_JOIN_CLUSTER = 0x0023;
	/** ͬ��Է�����Ⱥ */	
	public static final char QQ_RECV_IM_APPROVE_JOIN_CLUSTER = 0x0024;
	/** �ܾ��Է�����Ⱥ */
	public static final char QQ_RECV_IM_REJECT_JOIN_CLUSTER = 0x0025;
	/** ֪ͨ�ұ����뵽һ��Ⱥ��������Ⱥ��������ʱ��ͱ��ӵ� */
	public static final char QQ_RECV_IM_CREATE_CLUSTER = 0x0026;
	/** �յ���ϵͳ��Ϣ */ 
	public static final char QQ_RECV_IM_SYS_MESSAGE = 0x0030;
	/** ͬһ��QQ���������ط���¼���ұ��߳� */
	public static final char QQ_RECV_IM_KICK_OUT = 0x0001;
	
	// ��Ϣ���ͣ�������ͱ�������������ٵ�һ�������ǻ���������QQ_RECV_IM_TO_BUDDY
	//    ����������normalIMHeader�е�����
	/** ��ͨ�ļ���Ϣ */
	public static final char QQ_IM_NORMAL_TEXT = 0x000B;
	/** һ��TCP�������� */
	public static final char QQ_IM_TCP_REQUEST = 0x0001;
	/** ����TCP�������� */
	public static final char QQ_IM_ACCEPT_TCP_REQUEST = 0x0003;
	/** �ܾ�TCP�������� */
	public static final char QQ_IM_REJECT_TCP_REQUEST = 0x0005;
	/** UDP�������� */
	public static final char QQ_IM_UDP_REQUEST = 0x0035;
	/** ����UDP�������� */
	public static final char QQ_IM_ACCEPT_UDP_REQUEST = 0x0037;
	/** �ܾ�UDP�������� */
	public static final char QQ_IM_REJECT_UDP_REQUEST = 0x0039;
	/** ֪ͨ�ļ�����˿� */
	public static final char QQ_IM_NOTIFY_IP = 0x003B;
	/** ����Է��������� */
	public static final char QQ_IM_ARE_YOU_BEHIND_FIREWALL = 0x003F;
	/** δ֪���� */
	public static final char QQ_IM_ARE_YOU_BEHIND_PROXY = 0x0041;
	/** δ֪���⣬0x0041�Ļظ� */
	public static final char QQ_IM_YES_I_AM_BEHIND_PROXY = 0x0042;
	/** ֪ͨ�ļ���ת��������Ϣ */
	public static final char QQ_IM_NOTIFY_FILE_AGENT_INFO = 0x004B;
	/** ȡ��TCP����UDP�������� */
	public static final char QQ_IM_REQUEST_CANCELED = 0x0049;
	
	// ��֤���ͣ���һ����Ϊ����ʱ�Ƿ���Ҫ��֤�ȵ�
	/** ������֤ */
	public static final byte QQ_AUTH_NO_AUTH = 0;
	/** ��Ҫ��֤ */
	public static final byte QQ_AUTH_NEED_AUTH = 1;
	/** �Է��ܾ��Ӻ��� */
	public static final byte QQ_AUTH_NO_ADD = 2;
	
	// ����������������Ӻ�����֤�İ��У���ʾ�������󣬻�����ܾ�����ͬ����˵�����
	/** ͨ����֤ */
	public static final byte QQ_MY_AUTH_APPROVE = 0x30;
	/** �ܾ���֤  */
	public static final byte QQ_MY_AUTH_REJECT = 0x31;
	/** ������֤ */
	public static final byte QQ_MY_AUTH_REQUEST = 0x32;
	
	// ��ϵ�����Ŀɼ�����
	/** ��ȫ���� */
	public static final int QQ_CONTACT_OPEN = 0;
	/** �����ѿɼ� */
	public static final int QQ_CONTACT_ONLY_FRIENDS = 1;
	/** ��ȫ���� */
	public static final int QQ_CONTACT_CLOSE = 2;
	
	// ϵͳ֪ͨ������
	/** �Լ������˼�Ϊ���� */
	public static final char QQ_MSG_SYS_BEING_ADDED = 1;
	/** �Է��������Ϊ���� */
	public static final char QQ_MSG_SYS_ADD_FRIEND_REQUEST = 2;
	/** ͬ��Է����Լ�Ϊ���� */
	public static final char QQ_MSG_SYS_ADD_FRIEND_APPROVED = 3;
	/** �ܾ��Է����Լ�Ϊ���� */
	public static final char QQ_MSG_SYS_ADD_FRIEND_REJECTED = 4;
	/** δ֪���� */
	public static final char QQ_MSG_SYS_UPDATE_HINT = 9;
	
	// ���������û�ʱָ�������������ͣ������ǲ鿴ȫ�������û��������Զ������
	/** ��˭������ */
	public static final byte QQ_SEARCH_ALL = 0x31;
	/** �Զ������� */
	public static final byte QQ_SEARCH_CUSTOM = 0x30;
	
	// Ⱥ��Ϣ���ó����ַ�������Э���޹�
	/** ��ֹ��Ⱥһ����Ϣ */
	public static final String MSG_BLOCK = "block";
	/** ���ܸ�Ⱥ��Ϣ */
	public static final String MSG_ACCEPT = "accept";
	/** �Զ�������Ϣ */
	public static final String MSG_EJECT = "eject";
	/** ��¼��Ⱥ��Ϣ������ʾ */
	public static final String MSG_RECORD = "record";
	
	/* ����Ϊר�����ļ�����ʱ�ĳ��� */
	/** ��ʼ��ת������������Щ��ʼ�ķ�������ʼ����ֱ������һ��Ը���ṩ��ת�ķ�����Ϊֹ */
	public static final String[] originalAgents = new String[] {
	        "218.133.40.38",
	        "218.133.40.36",
	        "219.133.40.36"
	};
    /** QQ�ļ����Ͱ���ͷ���ֽڳ��� */
    public static final int QQ_FILE_PACKET_HEADER_LENGTH = 12;
    
    // �ļ�������Ϣ������������
    /** heart beat */
    public static final char QQ_FILE_CMD_HEART_BEAT 			= 0x0001;
    /** heart beat��ȷ�� */
    public static final char QQ_FILE_CMD_HEART_BEAT_ACK 		= 0x0002;
    /** �ļ���������� */
    public static final char QQ_FILE_CMD_TRANSFER_FINISHED 		= 0x0003;
    /** �ļ����� */
    public static final char QQ_FILE_CMD_FILE_OP 				= 0x0007;
    /** �ļ�������ȷ�� */
    public static final char QQ_FILE_CMD_FILE_OP_ACK 			= 0x0008;
    
    // QQ_FILE_CMD_FILE_OPЯ������Ϣ����
    /** �ļ�������Ϣ */
    public static final byte QQ_FILE_BASIC_INFO = 0x1;
    /** �ļ����� */
    public static final byte QQ_FILE_DATA_INFO = 0x2;
    /** �ļ�EOF */
    public static final byte QQ_FILE_EOF = 0x3;
    
    // �ļ�������Ϣ���������������
    /** ������say hello */
    public static final char QQ_FILE_CMD_SENDER_SAY_HELLO 		  = 0x0031;
    /** �Է�����hello��ȷ�� */
    public static final char QQ_FILE_CMD_SENDER_SAY_HELLO_ACK	  = 0x0032;
    /** ������say hello */
    public static final char QQ_FILE_CMD_RECEIVER_SAY_HELLO		  = 0x0033;
    /** �Խ�����hello��ȷ�� */
    public static final char QQ_FILE_CMD_RECEIVER_SAY_HELLO_ACK	  = 0x0034;
    /** ��֪ͨIP��ȷ�ϣ�����QQ_IM_NOTIFY_IP��ȷ�� */
    public static final char QQ_FILE_CMD_NOTIFY_IP_ACK 			  = 0x003C;
    /** ��̽���� */
    public static final char QQ_FILE_CMD_PING    				  = 0x003D;
    /** ��̽���ӵ�ȷ�� */
    public static final char QQ_FILE_CMD_PONG 					  = 0x003E;
    /** �������ӶԷ� */
    public static final char QQ_FILE_CMD_YES_I_AM_BEHIND_FIREWALL = 0x0040;
    
    // �ļ���ת��Ϣ������������
    /** ����������Է��ṩ��ת���� */
    public static final char QQ_FILE_CMD_REQUEST_AGENT = 0x0001;
    /** ����������ת���������� */
    public static final char QQ_FILE_CMD_CHECK_IN = 0x0002;
    /** ת�����������������Ƕ��һ���ļ�������Ϣ�� */
    public static final char QQ_FILE_CMD_FORWARD = 0x0003;
    /** ������� */
    public static final char QQ_FILE_CMD_FORWARD_FINISHED = 0x0004;
    /** ������֪ͨ���Կ�ʼ�������� */
    public static final char QQ_FILE_CMD_IT_IS_TIME = 0x0005;
    /** ���Ѿ�׼���� */
    public static final char QQ_FILE_CMD_I_AM_READY = 0x0006;
    
    // QQ_FILE_CMD_REQUEST_AGENT�����Ӧ������
    /** ��׼��ת���� */
    public static final char QQ_FILE_AGENT_SERVICE_APPROVED = 0x0000;
    /** ������æ�����ұ��˰� */
    public static final char QQ_FILE_AGENT_SERVICE_REDIRECTED = 0x0001;
	
    // �������ļ���Ϣ�е�һ����־�ֽڣ�0x65������Ǹ�����˼��������������
    /** UDP�����ܲ�������˼ */
    public static final byte QQ_TRANSFER_FILE_UDP = 0;
    /** ֱ��UDP�����ܲ�������˼ */
    public static final byte QQ_TRANSFER_FILE_DIRECT_UDP = 1;
    /** TCP�����ܲ�������˼ */
    public static final byte QQ_TRANSFER_FILE_TCP = 2;
    /** ֱ��TCP�����ܲ�������˼ */
    public static final byte QQ_TRANSFER_FILE_DIRECT_TCP = 3;
    
	// �����ļ��ĸ��������ÿ����������Ӧ�����Ӳ��ԣ������Э���޹أ����Լ������
    /** ˫��λ��ͬһ������ǽ�� */
	public static final int QQ_SAME_LAN = 0;
	/** ˫�������ڷ���ǽ�� */
	public static final int QQ_NONE_BEHIND_FIREWALL = 1;
	/** ���ڷ���ǽ�� */
	public static final int QQ_I_AM_BEHIND_FIREWALL = 2;
	/** ���ڷ���ǽ�� */
	public static final int QQ_HE_IS_BEHIND_FIREWALL = 3;
	/** ˫���ڲ�ͬ�ķ���ǽ�� */
	public static final int QQ_ALL_BEHIND_FIREWALL = 4;
	
	// say helloʱ��hello byte����ͬ���������ֽڲ�һ��
	/** ˫��λ��ͬһ������ǽ���Hello */
	public static final byte QQ_SAME_IN_TO_SAME_IN_HELLO = 0;
	/** һ�����ڷ���ǽ���ڲ������Ƿ��ͷ�ʱ��Hello */
	public static final byte QQ_IN_TO_OUT_HELLO = 1;
	/** һ�����ڷ���ǽ���ⲿ�����Ƿ��ͷ�ʱ��Hello */
	public static final byte QQ_OUT_TO_IN_HELLO = 2;
	/** ���������ڷ���ǽ��ʱ��Hello */
	public static final byte QQ_OUT_TO_OUT_HELLO = 0;
	
	/** ������MD5�ĳ��ȣ�������һ���ļ�ʱ���������ļ��ܴ���ֻ���ļ���ǰ��һ������MD5 */
	public static final int QQ_MAX_FILE_MD5_LENGTH = 10002432;
}
