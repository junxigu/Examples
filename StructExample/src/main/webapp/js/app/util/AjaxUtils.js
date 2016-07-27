define([], function() {

  return {

    getCommonRequestHandler: function(requestHandler){
      return function(data){
        var obj;
        if(data && !data.errorMsg){
          try{
            obj = JSON.parse(data);
            requestHandler && requestHandler(obj);
          } catch(e){
            $('html').html(data);
          }
        }
      };
    },
    
  };

});