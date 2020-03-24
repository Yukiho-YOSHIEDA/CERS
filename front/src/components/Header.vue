<template>
  <header>
    <div class="logo">
      <img alt="RCC logo" src="../assets/rcc-favicon.png" />
    </div>
    <div class="title">
      サークルルーム入退室ログシステム
    </div>
  </header>
</template>

<script>
export default {
  name: 'Header',
};
</script>

<style scoped>
  header {
    display: flex;
    align-items: center;
    width: 100vw;
    height: 170px;
    background-color: #f8931f;
  }

  .logo {
    padding: 10px;
    padding-left: 40px;
  }

  .logo > img {
    height: 150px;
  }

  .title {
    width: 100%;
    text-align: center;
    color: white;
    font-size: 65px;
  }
</style>
