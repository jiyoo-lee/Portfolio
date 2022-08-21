
$(function(){
	
		$("#config_cancel").click(function(){
			alert("작성이 취소되었습니다.");
			location.href="./configuration";	
	})

		$("#config_save").click(function() {
			
			var $config_title = $("#config_title").val();
			var $config_email = $("#config_email").val();
			var $point = $(':input[name="point"]:checked').val();
			var $default_point = $("#default_point").val();
			var $level = $("#level").val();
			var $company = $("#company").val();
			var $rg_num = $("#rg_num").val();
			var $m_director = $("#m_director").val();
			var $m_number = $("#m_number").val();
			var $report_number = $("#report_number").val();
			var $value_number = $("#value_number").val();
			var $postalcode = $("#postalcode").val();
			var $company_addr = $("#company_addr").val();
			var $info_manager = $("#info_manager").val();
			var $info_email = $("#info_email").val();
			var $bank = $("#bank").val();
			var $bank_account = $("#bank_account").val();
			var $credit = $(':input[name="credit"]:checked').val();
			var $mobile = $(':input[name="mobile"]:checked').val();
			var $voucher = $(':input[name="voucher"]:checked').val();
			var $min_point = $("#min_point").val();
			var $max_point = $("#max_point").val();
			var $receipt = $(':input[name="receipt"]:checked').val();
			var $shipping_name = $("#shipping_name").val();
			var $shipping_cost = $("#shipping_cost").val();
			var $delivery_date = $(':input[name="deliveryDate"]:checked').val();
			
			if($config_title == "" || $config_email == "" || $point == "" || $default_point == "" || $level == "")
				{ alert("홈페이지 가입 환경설정 정보를 모두 입력해주세요."); }
			else if ($company == "" || $rg_num == "" || $m_director == "" ||  
					 $postalcode == "" || $company_addr == "" || $info_manager == "" || $info_email == "")
					{ alert("홈페이지 기본 환경설정 정보를 모두 입력해주세요.");}	
			else if($bank == ""|| $bank_account == "" || $min_point == "" || $max_point == "" ||
					$shipping_name == "" || $shipping_cost == "") 
					{ alert("결제 기본 환경설정 정보를 모두 입력해주세요."); }
			else{
				$regxEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
				$regxRgnum = /([0-9]{3})-?([0-9]{2})-?([0-9]{5})/
				$regxAccount = /([0-9,\-]{3,6}\-[0-9,\-]{2,6}\-[0-9,\-])/
				if($regxEmail.test($config_email) == false) {
					alert("올바른 이메일 형식이 아닙니다.");
				}
				else if ($regxRgnum.test($rg_num) == false){
					alert("올바른 등록번호 형식이 아닙니다.");
				}
				else if($regxAccount.test($bank_account) == false){
					alert("올바른 계좌 형식이 아닙니다.");
				}
				else{
					if(confirm("저장하시겠습니까?")){						
						frm.method ="POST";
						frm.enctype="application/x-www-form-urlencoded";
						frm.action = "./configuration";
						frm.submit();
					}
				}
			}
		})
		
});