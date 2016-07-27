/** @jsx React.DOM */
'use strict';
define([
  'react',
  'mixin/BackboneViewMixin',
], function(React, BackboneViewMixin) {

  var ReactPropTypes = React.PropTypes;

  var RoleSetting = React
    .createClass({

      mixins: [BackboneViewMixin],
      
      propTypes : {
        count : ReactPropTypes.number.isRequired,
        title : ReactPropTypes.string.isRequired,
        opt : ReactPropTypes.number.isRequired,
        roleName : ReactPropTypes.string.isRequired,
        onChange : ReactPropTypes.func.isRequired,
      },

      getDefaultProps : function() {
        return {
          min : 1,
        };
      },

      render : function() {
        var props = this.props, count = props.count, opt = props.opt
          || props.min, options = [], select = [];

        for (var i = props.min; i <= count; i++) {
           options.push(<option key={i} value={i}>{i}</option>);
        }

         return (
           <li>
             <div className='col-xs-6'>
               <label>{props.title}</label>
             </div>
             <div className='col-xs-6'>
               <select data-mini='true' defaultValue={opt}>
                 {options}
               </select>
             </div>
           </li>
         );
      },

      events: {
        'change select': 'onChange',
      },
      
      onChange: function(event) {
        var props = this.props;
        if(!props.onChange(props.roleName, parseInt(event.target.value))){
          $(event.target).val(props.opt).selectmenu('refresh');
        }
      },
    });

  return RoleSetting;
});
