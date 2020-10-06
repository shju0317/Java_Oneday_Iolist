$(function () {
	$("#delete").click(function(){
		if(confirm("정말 삭제할까요?")){
			document.location.href = "${rootPath}/products/delete?seq=${product.io_seq}"
		}
	})
	
	$("#update").click(function(){
		document.location.href="${rootPath}/products/update?seq=${product.io_seq}"
	})
});