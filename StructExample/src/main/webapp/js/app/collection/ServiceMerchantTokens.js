define([ 'backbone', 'model/ServiceMerchantToken', 'util/AjaxUtils', ],
  function(Backbone, ServiceMerchantToken, AjaxUtils) {

    return Backbone.Collection.extend({

      model : ServiceMerchantToken,

    }, {

      getMerchantTokens : function(handleTokensData) {
        var fetchUrl = '/speedpasselement/serviceMerchantTokens/fetch';
        $.post(fetchUrl, AjaxUtils.getCommonRequestHandler(handleTokensData));
      },
    });

  });