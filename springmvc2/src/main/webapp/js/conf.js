define(['collection/ServiceMerchantTokens'], function(ServiceMerchantTokens) {

  return {

    Tokens: new ServiceMerchantTokens([ {
      id : 1,
      serviceMerchantId : 1,
      countryCode : 1,
      alias : 'alias',
      password : 'password',
      partnerId : 'partnerId',
      systemId : 'systemId',
      certificate : 'certificate',
      description : 'description',
      creationTime : 'creationTime',
      updateTime : 'updateTime',
    }, {
      id : 2,
      serviceMerchantId : 2,
      countryCode : 2,
      alias : 'alias',
      password : 'password',
      partnerId : 'partnerId',
      systemId : 'systemId',
      certificate : 'certificate',
      description : 'description',
      creationTime : 'creationTime',
      updateTime : 'updateTime',
    }, {
      id : 3,
      serviceMerchantId : 3,
      countryCode : 3,
      alias : 'alias',
      password : 'password',
      partnerId : 'partnerId',
      systemId : 'systemId',
      certificate : 'certificate',
      description : 'description',
      creationTime : 'creationTime',
      updateTime : 'updateTime',
    } ]),

  };

});