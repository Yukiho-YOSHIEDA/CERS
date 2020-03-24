module.exports = {
  devServer: {
    proxy: {
      '/ws': {
        target: 'http://localhost:8080',
        ws: true,
        changeOrigin: true,
      },
      '/api/v1': {
        target: 'http://localhost:8080',
      },
    },
  },
};
