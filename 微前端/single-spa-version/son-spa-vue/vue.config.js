// 配置将子应用打包成一个个的lib去给父应用使用

module.exports = {
    configureWebpack: {
        output: {
            library: 'singleVue',//导报
            libraryTarget: 'umd'//umd模块作用，window.singleVue.bootstrap/mount/unmount，将这些挂在window上
        },
        devServer: {//区别是子应用
            port: 10000
        }
    }
}
