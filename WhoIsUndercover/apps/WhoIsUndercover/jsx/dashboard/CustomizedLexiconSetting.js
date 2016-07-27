/** @jsx React.DOM */
'use strict';
define([
  'react',
  'mixin/BackboneViewMixin',
  'action/Actions',
], function(React, BackboneViewMixin, Actions) {

  var ReactPropTypes = React.PropTypes;

  var CustomizedLexiconSetting = React.createClass({

    mixins : [ BackboneViewMixin ],

    propTypes : {
      specifiedWords : ReactPropTypes.array.isRequired,
    },

    render : function() {
      var specifiedWords = this.props.specifiedWords;
      
      return (
        <ul data-role='listview'>
          <li>
            <span>平民</span>
            <input id='common' data-mini='true' name='common' 
              defaultValue={specifiedWords[0]} />
          </li>
          <li>
            <span>卧底</span>
            <input id='undercover' data-mini='true' name='undercover'
              defaultValue={specifiedWords[1]} />
          </li>
        </ul>
      );
    },

    events : {
      'change input' : 'onChange',
      'focus input' : 'hideBottomEle',
      'blur input' : 'showBottomEle',
    },

    hideBottomEle: function() {
      $('.bottom').hide();
    },
    
    showBottomEle: function() {
      $('.bottom').show();
    },
    
    onChange : function(event) {
      Actions.changeSpecifiedType($(event.target).attr('id') === 'common' ? 0 : 1,
        $(event.target).val());
    },
  });

  return CustomizedLexiconSetting;
});
