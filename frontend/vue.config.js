// const { defineConfig } = require('@vue/cli-service')
// module.exports = defineConfig({
//   transpileDependencies: true
// })
const path = require("path");
module.exports = {
  outputDir: path.resolve(__dirname, "../backend/src/main/resources/static"),
  indexPath: path.resolve(__dirname, "../backend/src/main/resources/static/index.html"),
  devServer: {
    port: 3000,
    proxy: {
      //경로가 /api 일때에는 target으로 우회 하겠다는 의미
      '/': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        pathRewrite: {
          // '^/': ''
        }
      }
    }
  },
}