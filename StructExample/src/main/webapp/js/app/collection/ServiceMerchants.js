define([ 'backbone', 'model/ServiceMerchant', 'util/AjaxUtils', ],
  function(Backbone, ServiceMerchant, AjaxUtils) {

    var ServiceMerchants =  Backbone.Collection.extend({

      model : ServiceMerchant,

    }, {

      getServiceMerchants : function(handleCollection) {
        var fetchUrl = '/speedpasselement/serviceMerchantTokens/merchants';
        $.post(fetchUrl, AjaxUtils.getCommonRequestHandler(function(jsonData){
          handleCollection && handleCollection(new ServiceMerchants(jsonData));
        }));
      },
    });
    
    return ServiceMerchants;
  });