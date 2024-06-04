function check(){
    if(document.getElementById("jumin").value.trim().length == 0){
        alert("주민번호가 입력되지 않았습니다.")
        document.getElementById("jumin").focus();
        return false
    }
    if(document.getElementById("v_code").value.length == 0){
        alert("백신코드가 선택되지 않았습니다.")
        document.getElementById("v_code").focus();
        return false
    }
    if(document.getElementById("inlineRadio1").value.length == 0
        || document.getElementById("inlineRadio2").value.length == 0
        || document.getElementById("inlineRadio3").value.length == 0
        || document.getElementById("inlineRadio4").value.length == 0){
            alert("예약 병원이 선택되지 않았습니다.")
            return false
    }
    if(document.getElementById("resv_date").value.length == 0){
            alert("예약날짜가 입력되지 않았습니다.")
            document.getElementById("v_code").focus();
            return false
    }
    if(document.getElementById("resv_time").value.length == 0){
            alert("예약시간이 입력되지 않았습니다.")
            document.getElementById("v_code").focus();
            return false
    }
    alert("입력이 완료되었습니다.")
    document.getElementById("frm").submit()
    return true
}

function res(){
    alert("처음부터 다시 입력합니다.")
    document.getElementById("frm").reset()
    document.getElementById("title").focus();

}

function searchCheck(){
    var keywordInput = document.getElementById("keyword");

    if(keywordInput.value.trim() === ""){
        alert("검색어를 입력하세요!");
        keywordInput.focus();
    } else {
        document.getElementById("frm").submit()
    }
}