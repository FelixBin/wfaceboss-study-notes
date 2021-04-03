// 配置将子应用打包成一个个的lib去给父应用使用

module.exports={
    devServer:{
        port:10000,
        headers:{
            'Access-Control-Allow-Origin':'*'//允许访问跨域
        }
    },
    configureWebpack:{
        output:{
            library:'qiankun-vue',
            libraryTarget:'umd'
        }
    }
}
