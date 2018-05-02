package util;

public class Page {
	int start;
	int count;
	int total;
	String param;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Page(int start, int count) {
		super();
		this.start = start;
		this.count = count;
	}
	
	public boolean isHasPreviouse(){
		if(start==0)
			return false;
		return true;
		
	}
	public boolean isHasNext(){
		if(start==getLast())
			return false;
		return true;
	}
	
	public int getTotalPage(){
		int totalPage;
        // 鍋囪鎬绘暟鏄�50锛屾槸鑳藉琚�5鏁撮櫎鐨勶紝閭ｄ箞灏辨湁10椤�
        if (0 == total % count)
            totalPage = total /count;
        // 鍋囪鎬绘暟鏄�51锛屼笉鑳藉琚�5鏁撮櫎鐨勶紝閭ｄ箞灏辨湁11椤�
        else
            totalPage = total / count + 1;
        
        if(0==totalPage)
        	totalPage = 1;
        return totalPage;
		
	}
	
	public int getLast(){
		int last;
        // 鍋囪鎬绘暟鏄�50锛屾槸鑳藉琚�5鏁撮櫎鐨勶紝閭ｄ箞鏈�鍚庝竴椤电殑寮�濮嬪氨鏄�45
        if (0 == total % count)
            last = total - count;
        // 鍋囪鎬绘暟鏄�51锛屼笉鑳藉琚�5鏁撮櫎鐨勶紝閭ｄ箞鏈�鍚庝竴椤电殑寮�濮嬪氨鏄�50
        else
            last = total - total % count;
        
        last = last<0?0:last;
        return last;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	
}

/**
* 妯′豢澶╃尗鏁寸珯j2ee 鏁欑▼ 涓篽ow2j.cn 鐗堟潈鎵�鏈�
* 鏈暀绋嬩粎鐢ㄤ簬瀛︿範浣跨敤锛屽垏鍕跨敤浜庨潪娉曠敤閫旓紝鐢辨寮曡捣涓�鍒囧悗鏋滀笌鏈珯鏃犲叧
* 渚涜喘涔拌�呭涔狅紝璇峰嬁绉佽嚜浼犳挱锛屽惁鍒欒嚜琛屾壙鎷呯浉鍏虫硶寰嬭矗浠�
*/	
