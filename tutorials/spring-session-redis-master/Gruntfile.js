'use strict';
var grunt = require('grunt');

module.exports = function(grunt) {

  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    app: {
            source: 'src/main/webapp',
            dist: 'src/main/webapp'
    },
    uglify: {
            dist: {
                   options: {
                       compress: true,
                       preserveComments: false,
                       report: 'min'
                   },
                   files: {
                       '<%= app.dist %>/dist/js/vendor-scripts.js': [
                           'app/bower_components/jquery/dist/jquery.js',
                           'app/bower_components/angular/angular.js',
                           'app/bower_components/angular-ui-router/release/angular-ui-router.js',
                           'app/bower_components/angular-animate/angular-animate.js',
                           'app/bower_components/angular-aria/angular-aria.js',
                           'app/bower_components/angular-material/angular-material.js',
                           'app/bower_components/angular-messages/angular-messages.js'
                      ],
                       '<%= app.dist %>/dist/js/custom-scripts.js': [
                           '<%= app.source %>/js/app.js'
                       ]
                   }
               }
    }
});

   grunt.loadNpmTasks('grunt-contrib-uglify');

   grunt.loadNpmTasks('grunt-install-dependencies');
   grunt.registerTask('default', ['uglify:dist']);
};
