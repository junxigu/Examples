define([ 'backbone', 'sub/TdRowView' ], function(Backbone, TdRowView) {

  return Backbone.View.extend({
    el : '#tokenTable',

    thText : $('#table-head-col').html(),

    emptyColNum : 2,

    header : {
      'ID' : 'id',
      'MERCHANT' : 'serviceMerchantId',
      'COUNTRY CODE' : 'countryCode',
      'ALIAS' : 'alias',
      'PASSWORD' : 'password',
      'PARTNER ID' : 'partnerId',
      'SYSTEM ID' : 'systemId',
      'CERTIFICATE' : 'certificate',
      'DESCRIPTION' : 'description',
      'CREATION TIME' : 'creationTime',
      'UPDATE TIME' : 'updateTime',
    },

    initialize : function(tokens) {
      this.tokens = tokens;
      return this;
    },

    render : function() {
      this.$tbody = this.$('tbody');
      this.renderTitle().renderContent();
      return this;
    },

    renderTitle : function() {
      var $tr = this.$('thead tr');

      this.appendEmptyCols(this.emptyColNum, $tr);
      for (title in this.header) {
        this.appendTitleCol(title, $tr);
      }
      return this;
    },

    appendEmptyCols : function(num, $tr) {
      for (var i = 0; i < num; i++) {
        this.appendTitleCol('', $tr);
      }
    },

    appendTitleCol : function(title, $tr) {
      var template = _.template(this.thText);
      $tr.append(template({
        title : title
      }));
      return this;
    },

    renderContent : function() {
      this.tokens.each(this.insertToken.bind(this));
      return this;
    },

    deleteToken : function(data) {
      var tokens = this.tokens;
      var token = this.tokens.findWhere({
        id: data.id,
      });
      token && tokens.remove(token);
      return this;
    },
    
    insertToken: function(token) {
      var view = new TdRowView(token);
      this.tokens.add(token);
      this.$tbody.append(view.render().$el);
      this.listenTo(view, 'removeToken', this.deleteToken.bind(this));
    },
  });

});