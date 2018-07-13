$(document).ready(function() {

    // create a new instance of the plugin
    var myplugin = new $.pluginName($('#divTest'));

    // call a public method
    myplugin.foo_public_method();

    // get the value of a public property
    myplugin.settings.property;

});