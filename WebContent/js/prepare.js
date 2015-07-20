$(document).ready(function(){
	//$("#btn_hostname").on("click", hostname_check);
	$("#btn_start_input").on("click", load_general_info);
    $("#btn_server_input").on("click", load_server_info);
});

function hostname_check() {
    console.log("start");
    var ip_string = $("#IP").val();
    console.log(ip_string);
    $.get("get_hostname.jsp", {"ip": ip_string}, function(data){
    	console.log("in ajax");
        console.log(data);
        $("#result").text(data);
    });
}

function load_general_info() {
	$.get("domain_general_info.html", function(data){
        $("#domain_general_info").prepend(data);
        //$("#pre_input").hide();
        $("#btn_server_input").show();
    });
}

function load_server_info() {
    $.get("domain_server_info.html", function(data){
        $("#domain_server_info").html(data);
        //$("#domain_general_info").hide();
    });
}