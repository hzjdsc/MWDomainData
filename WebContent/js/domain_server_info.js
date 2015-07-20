/**
 * Created by casy on 15-6-24.
 */
var node_count = 6;
var domain_name = "gaa";

var default_http_port = 7001;
var default_managed_http_port = default_http_port+10;
var ip_list=['113.52.164.114', '113.52.164.115'];
var instance_type_list=['admin', 'managed'];

$(document).ready(function(){
    insert_select_options();
    set_admin_server("gaa");
    $("#btn_add_managed_server").on("click", add_managed_server);
});

function insert_select_options() {
    for (var i in ip_list) {
        var ip = ip_list[i];
        $("#server_template [name='server_ip']").append('<option value="'+ip+'">'+ip+'</option>');
    }

    for (i in instance_type_list) {
        var type = instance_type_list[i];
        $("#server_template [name='instance_type']").append('<option value="'+type+'">'+type+'</option>');
    }
}

function set_admin_server(domain_name) {
    $("#admin_server").html($("#server_template").html());
    $("#admin_server [name='instance_name']").val(domain_name+"_admin");
    $("#admin_server [name='instance_type']").val("admin");
    $("#admin_server [name='http_port']").val(default_http_port);
    $("#admin_server [name='https_port']").val(default_http_port+1);
    $("#admin_server [name='server_ip']").val(ip_list[0]);
}

var port_factor=0;

function add_managed_server() {
    var ip_count = ip_list.length;
    for (var node_index = 1; node_index<=node_count; node_index++ ) {
        var id = "managed_server_"+node_index;
        var ip_index = (node_index-1)%ip_count;
        var port_factor = Math.floor((node_index-1)/ip_count);

        $("#btn_server_info_finished").before('<div id="'+id+'">'+$("#server_template").html()+'</div>');

        $("#"+id+" [name='instance_name']").val(domain_name+"_00"+node_index);
        $("#"+id+" [name='instance_type']").val("managed");
        $("#"+id+" [name='http_port']").val(default_managed_http_port+port_factor*4);
        $("#"+id+" [name='https_port']").val(default_managed_http_port+port_factor*4+1);
        $("#"+id+" [name='server_ip']").val(ip_list[ip_index]);
        if(node_index == node_count) {
            $("#btn_add_managed_server").hide();
            $("#btn_server_info_finished").show();
        }
    }
}
