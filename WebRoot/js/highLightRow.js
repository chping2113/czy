//added by zhanggj at 2011.1.6
jQuery(function($) {
	var trs = $(".table_list tr");

	trs.each(function(index, domEle) {
		if(index == 0) { //break table header
			return;
		}
		
		var ele = $(domEle);
		
		ele.mouseover(function(evt) {
			ele.addClass("highLightRow");
		});
		
		ele.mouseout(function(evt) {
			ele.removeClass("highLightRow");
		});
	});
});