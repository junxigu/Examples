/** @jsx React.DOM */
'use strict';
define([
  'react',
  'mixin/BackboneViewMixin',
], function(React, BackboneViewMixin) {

  var ReactPropTypes = React.PropTypes;

  var LexiconCheckbox = React.createClass({

    mixins: [BackboneViewMixin],
    
    propTypes : {
      index : ReactPropTypes.number.isRequired,
      type : ReactPropTypes.string.isRequired,
    },

    render : function() {
      var props = this.props, id = 'type' + props.index;
      
      return (
          <label htmlFor={id}>{props.type}
          <input type='checkbox' data-mini='true' id={id} value={props.type}
            name='randomType' defaultChecked={props.checked} /></label>
      );
    },
    
  });

  return LexiconCheckbox;
});
