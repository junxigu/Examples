$(function() {
  var datepicker = $("#datepicker");
  datepicker.datepicker({ 
    defaultDate: 0,
  }).datepicker( "option", "defaultDate" );
  datepicker.on("change", function(){
    location = "http://" + location.host + "/promotion/promotion" 
      + "?periodStart=" + datepicker.val(); 
  });
});