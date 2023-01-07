var system = "";
var startPrice = "";
var endPrice = "";
var orderByPrice = "";
var priceType = getURLParam("p");
$(document).ready(function () {
	system = getUrlParams('sys');
	initPriceSearch();
	initSystemSearch();
	queryGoodsInfo();
});

function setPrice(priceLH){
	if("" != priceLH){
		startPrice = priceLH.split("-")[0];
		endPrice = priceLH.split("-")[1];
	}else{
		startPrice ="";
		endPrice ="";
	}
	queryGoodsInfo();
}
function setOrder(type){
	orderByPrice = type;
	queryGoodsInfo();
}

function setSystem(selectSystem){
	system = selectSystem;
	queryGoodsInfo();
}
function initPriceSearch(){
	$.ajax({
	    url: 'sys/queryPriceSetting.do',
	    type: 'post',
	    data: {game:'route'},
	    dataType: 'json',
	    success: function (result) {
	        if (result.res) {
	        	var htmlText = '<li><a href="javascript:setPrice(\'\')">全部</a></li>';
	        	var priceList = result.data;
	        	for(var i=0;i<priceList.length;i++){
	        		htmlText += '<li><a href="javascript:setPrice(\''+priceList[i]+'\')">'+priceList[i]+'</a></li>';
	        	}
	        	htmlText += '<div>';
	        	$("#priceSearch").html(htmlText);
	        }
	        else {
	            alert(result.msg);
	        }
	    }
	});
}
function initSystemSearch(){
	$.ajax({
	    url: 'sys/queryOptions.do',
	    type: 'post',
	    data: {itemId:"40"},
	    dataType: 'json',
	    success: function (result) {
        	var htmlText = '<li><a href="javascript:setSystem(\'\')">全部</a></li>';
        	for(var i=0;i<result.length;i++){
        		htmlText += '<li><a href="javascript:setSystem(\''+result[i].optionName+'\')">'+result[i].optionName+'</a></li>';
        	}
        	htmlText += '<div>';
        	$("#systemSearch").html(htmlText);
	    }
	});
}
function queryGoodsInfo(){
	$.ajax({
	    url: 'sys/queryAllGoods.do',
	    type: 'post',
	    asyn:false,
	    data: {game:'route',startPrice:startPrice,endPrice:endPrice,orderByPrice:orderByPrice,system:system,priceType: priceType},
	    dataType: 'json',
	    success: function (result) {
	        if (result.res) {
	        	var goodsList = result.data;
	        	var dataList=[];
	            $('.box').pagination({
	                   totalData:goodsList.length,
	                   showData:20,
	                   coping:true,
	                   jump:true,
	                   keepShowPN:true,
	                   homePage:'首页',
	                   endPage:'末页',
	                   prevContent:'上页',
	                   nextContent:'下页',
	                   callback:function(api){
	                         $('.now').text(api.getCurrent());
	                         api.getCurrent();
	                         $("#goodsInfoDiv").text("");
	                         
	                         if(api.getCurrent() == 1){
	                             for(var i=0;i<20;i++){
	                            	 if(goodsList[i] == undefined){
	                            		 break;
	                            	 }
	                                    $('<a href="goodsDetail.html?id='+goodsList[i].id+'&p='+priceType+'" class="aui-grid-row-item">'+
	                                    		'<i class="aui-icon-large aui-icon-sign"><img src="userImg/goodsHeadPic/'+goodsList[i].id+'_headPic.png" onerror="javascript:this.src=\'img/defultPic.jpg\';"></i>'+
	                                    		'<p class="aui-grid-row-label"><font size="3px">'+goodsList[i].goodsName+'</font></br><font color="red" size="2px">￥'+goodsList[i].price+'</font></p>'
	                                    		).appendTo("#goodsInfoDiv");
	                                }
	                         }else{
	                             var next= (api.getCurrent())*20;
	                             if(next > goodsList.length){
	                                 next = goodsList.length;
	                             }
	                             for(var i= (api.getCurrent()-1)*20;i<next;i++){
	                            	 if(goodsList[i] == undefined){
	                            		 break;
	                            	 }
	                             $('<a href="goodsDetail.html?id='+goodsList[i].id+'&p='+priceType+'" class="aui-grid-row-item">'+
                                 		'<i class="aui-icon-large aui-icon-sign"><img src="userImg/goodsHeadPic/'+goodsList[i].id+'_headPic.png" onerror="javascript:this.src=\'img/defultPic.jpg\';"></i>'+
                                		'<p class="aui-grid-row-label"><font size="3px">'+goodsList[i].goodsName+'</font></br><font color="red" size="2px">￥'+goodsList[i].price+'</font></p>'
                                		).appendTo("#goodsInfoDiv");
	                           }
	                         }
	                         
	                   }
	                        
	                 },function(api){
	                	 
	                      $('.now').text(api.getCurrent());
	                      $("#goodsInfoDiv").html("");
	                          for(var i=0;i<20;i++){
	                        	  if(goodsList[i] == undefined){
	                            		 break;
	                            	 }
	                                $('<a href="goodsDetail.html?id='+goodsList[i].id+'&p='+priceType+'" class="aui-grid-row-item">'+
                                    		'<i class="aui-icon-large aui-icon-sign"><img src="userImg/goodsHeadPic/'+goodsList[i].id+'_headPic.png" onerror="javascript:this.src=\'img/defultPic.jpg\';"></i>'+
                                    		'<p class="aui-grid-row-label"><font size="3px">'+goodsList[i].goodsName+'</font></br><font color="red" size="2px">￥'+goodsList[i].price+'</font></p>'
                                    		).appendTo("#goodsInfoDiv");
	                            dataList.push(goodsList[i]);
	                          }
	                });
	        }
	        else {
	            alert(result.msg);
	        }
	    }
	});
}
function getUrlParams(name) { // 不传name返回所有值，否则返回对应值
    var url = window.location.search;
    if (url.indexOf('?') == 1) { return false; }
    url = url.substr(1);
    url = url.split('&');
    var name = name || '';
    var nameres;
    // 获取全部参数及其值
    for(var i=0;i<url.length;i++) {
        var info = url[i].split('=');
        var obj = {};
        obj[info[0]] = decodeURI(info[1]);
        url[i] = obj;
    }
    // 如果传入一个参数名称，就匹配其值
    if (name) {
        for(var i=0;i<url.length;i++) {
            for (const key in url[i]) {
                if (key == name) {
                    nameres = url[i][key];
                }
            }
        }
    } else {
        nameres = url;
    }
    // 返回结果
    return nameres;
}
