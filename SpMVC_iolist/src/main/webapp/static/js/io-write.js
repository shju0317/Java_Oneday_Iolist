$(function () {

	  $("#btn-save").click(function () {    
	    // 유효성검사는 일단 생략
	    $("form").submit();
	  });

	  $(document).on("click", "div.product-select", function () {
	  

	    $.ajax()
	      .done(function (productVO) {
	        // alert(JSON.stringify(productVO))

	        $("#io_seq").val(productVO.io_seq);
	        $("#io_date").val(productVO.io_date);
	        $("#io_time").val(productVO.io_time);
	        $("#io_pname").val(productVO.io_pname);
	        
	        //$("#io_inout").val(chk);
	        
	        $("#io_price").val(productVO.io_price);
	        $("#io_quan").val(productVO.io_quan);
	        
	        //$("#io_total").val(total);
	        
	        
	      })
	      .fail(function (xhr, textStatus, error) {
	        alert("서버와 통신오류 :()");
	      });
	  });
	});