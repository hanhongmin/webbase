package com.inmyshow.webbase;

/**
 * @author HanHongmin 1：服装类 2：鱼竿 3：鱼饵 4：家具类 5：动作类 6：用户食物 7：家具装饰-墙 8：家具装饰-门 9：家居装饰-窗 10：VIP道具
 *         11：家居装饰-地板 12：墙纸 13：地表
 *         100tops上衣,101shoes鞋,102bottoms裤子,103other头发,104goods帽子,105accessories饰品
 *         200 furniture 家具，201 appliance 家电，202 floor 地板，203 win 窗户，204 wall 墙，205 sundries 摆件，
 *         206 underside 地表，207 metope 墙纸 ，208 door 门，209 other 其他
 *         300 party 派对
 */
public enum ItemType {
	Shangyi(100, "tops")
	, Xie(101, "shoes")
	, Kuzi(102, "bottoms")
	, Toufa(103, "other")
	, Maozi(104, "goods")
	, Shipin(105, "accessories")
	, Jiaju(200, "furniture")
	, Jiadian(201, "appliance")
	, Diban(202, "floor")
	, Chuanghu(203, "win")
	, Qiang(204, "wall")
	, Baijian(205, "sundries")
	, Dibiao(206, "underside")
	, Qiangzhi(207, "metope")
	, Men(208, "door")
	, Qita(209, "other1")
	, Paidui(300, "party")
	;
	private int value;
	private String name;

	private ItemType(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static ItemType getTypeFromString(String type){
		switch (type) {
			case "tops":
				return ItemType.Shangyi;
			case "shoes":
				return ItemType.Xie;
			case "bottoms":
				return ItemType.Kuzi;
			case "other":
				return ItemType.Toufa;
			case "goods":
				return ItemType.Maozi;
			case "accessories":
				return ItemType.Shipin;
			case "furniture":
				return ItemType.Jiaju;
			case "appliance":
				return ItemType.Jiadian;
			case "floor":
				return ItemType.Diban;
			case "win":
				return ItemType.Chuanghu;
			case "wall":
				return ItemType.Qiang;
			case "sundries":
				return ItemType.Baijian;
			case "underside":
				return ItemType.Dibiao;
			case "metope":
				return ItemType.Qiangzhi;
			case "door":
				return ItemType.Men;
			case "other1":
				return ItemType.Qita;
			case "party":
				return ItemType.Paidui;
			default:
				return null;
		}
	}
	public static ItemType getTypeFromInt(int type){
		switch (type) {
			case 100:
				return ItemType.Shangyi;
			case 101:
				return ItemType.Xie;
			case 102:
				return ItemType.Kuzi;
			case 103:
				return ItemType.Toufa;
			case 104:
				return ItemType.Maozi;
			case 105:
				return ItemType.Shipin;
			case 200:
				return ItemType.Jiaju;
			case 201:
				return ItemType.Jiadian;
			case 202:
				return ItemType.Diban;
			case 203:
				return ItemType.Chuanghu;
			case 204:
				return ItemType.Qiang;
			case 205:
				return ItemType.Baijian;
			case 206:
				return ItemType.Dibiao;
			case 207:
				return ItemType.Qiangzhi;
			case 208:
				return ItemType.Men;
			case 209:
				return ItemType.Qita;
			case 300:
				return ItemType.Paidui;
			default:
				return null;
		}
	}
}
