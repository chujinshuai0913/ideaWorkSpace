package common.constant;

public class ConstantsUtils {

	public static class UserCode {
		public static final String DB_T_PRIMARY_KEY = "id";
		public  static final String USER_SESSION="USER_SESSION";
	}

	/*书籍分类*/
	public static class TypeBookClass {

		public static final int TYPE_CLASS_STATUS_NOT = 2;//不可用
		public static final int TYPE_CLASS_STATUS = 1;//可用
	}

	public static class UserShareCode {
		public static final int STATUS_NOT = 2;//不可用
		public  static final int STATUS=1;//可用
	}
	public static class BookAuditCode {
		public static final int AUDIT_NOT = 1;//未审核
		public  static final int AUDIT=2;//已审核
		public  static final int STOP=3;//禁卖
	}
	public static class BookTradeCode {
		public static final int TRADE_NOT = 1;//未交易
		public  static final int TRADE=2;//交易中
		public  static final int TRADE_STOP=3;//交易失败
	}
	public static class BookGradeCode {
		public static final int GRADE = 0;//通用
		public  static final int GRADE_A=1;//大一
		public  static final int GRADE_B=2;//大二
		public  static final int GRADE_C=3;//大三
		public  static final int GRADE_D=4;//大四
		public  static final int GRADE_E=5;//研一
		public  static final int GRADE_F=6;//研二
		public  static final int GRADE_G=7;//研三
		public  static final int GRADE_H=8;//博士
	}
	public static class  BookSemesterNameCode {
		public  static final int SEMESTER = 0;//通用
		public  static final int SEMESTER_UP=1;//上学期
		public  static final int SEMESTER_DOWN=2;//下学期
	}
	public static class  ShareAnnouncementImgNum {
		public  static final int NUM = 5;//显示图片数量

	}
	public static class  BookHotNum {
		public  static final int BookHotNum = 8;//近期热销书籍

	}
    public static class  BookTop {
        public  static final int BookTopNum = 10;//热销书籍
        public  static final int BookTopIndexNum =16;//首页图书推荐书记数目
		public  static final int BookTopProNum =12;//首页图书推荐书记数目

    }
	public static class  BookClassTop {
		public  static final int BookClass1TopNum = 18;//显示图书分类的数目
		public  static final int BookClass2TopNum =50;//首页图书推荐书记数目
		public  static final int BookPro1TopNum = 10;//显示图书分类的数目
		public  static final int BookPro2TopNum =50;//首页图书推荐书记数目
	}
}
