/**
 * Created by casy on 15-6-23.
 */
$(document).ready(function(){
    show_software_version();
    show_default_pwd();
    $("#software").on("change", show_software_version);
    $("#software_version").on("change", show_jdk_version);
    $("#jdk_version").on("change", input_other_jdk);
    $("#pwd_select").on("change",  change_pwd);

});

var db = {
    "WLS": {
    	"default_user" : "weblogic",
    	"versions" : 
    		{	
    			"10.3.6.0.2": "1.6.0_37",
    			"12.1.3.0.0": "1.7.0_67"
            }        
    },
    "SOA": {
    	"default_user" : "system",
    	"versions" : 
			{	
	    		"11.1.1.6.0": "1.6.0_31",
	            "11.1.1.7.0": "1.6.0_31"
	        }
    },
    "default_pwd" : "Pass1234",

};

function show_software_version() {   //根据不同的软件展示各自不同的软件版本号
    var software = $("#software").val();
    var software_version_array = Object.keys(db[software]['versions']);
    $("#software_version").empty();
    for (var i in software_version_array) {
        var version = software_version_array[i];
        $("#software_version").append('<option value="'+version+'">'+version+'</option>');
    }
    show_jdk_version(); //jdk联动
    $("#weblogic_user").val(db[software]['default_user']); //WLS和SOA有各自默认的用户名
}

function show_jdk_version() {
    var software = $("#software").val();
    var software_version = $("#software_version").val();
    var jdk_version = db[software]['versions'][software_version];
    $("#default_jdk_version").attr("value",jdk_version);
    $("#default_jdk_version").attr("selected", "selected");
    $("#default_jdk_version").text(jdk_version);
    input_other_jdk()
}

function input_other_jdk() {
    if ($("#jdk_version").val() == "other_jdk") {
        $("#other_jdk_version").show();
    } else {
        $("#other_jdk_version").hide();
    }
}

function show_default_pwd() {
	$("#test_pwd").attr("selected", "selected");
	$("#weblogic_password").attr("value", db['default_pwd']);
}

function change_pwd() {
	var pwd_type = $("#pwd_select").val();
	if (pwd_type == 'test_pwd') {
		$("#weblogic_password").attr("value", db['default_pwd']);
	} else if (pwd_type == 'prod_pwd') {
		$("#weblogic_password").attr("value", generate_pwd());
	}
}

