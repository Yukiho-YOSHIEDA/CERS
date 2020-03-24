<template>
  <div class="log">
    <Header />
    <div class="main">
      <div class="table-wrapper">
        <table>
          <thead>
            <tr>
              <th>記録時間</th>
              <th>学生番号</th>
              <th>名前</th>
              <th>入室・退室</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(log, index) in logList" :key="'log-' + index">
              <td>{{ log.createdAt }}</td>
              <td>{{ log.id }}</td>
              <td>{{ log.name }}</td>
              <td>{{ log.mode == 'enter' ? "入室" : "退室" }}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
    <div class="button-container">
      <div class="button-wrapper">
        <a href="/api/v1/records/download/csv" class="cers-button">CSV ダウンロード</a>
        <router-link to="/" tag="button" class="cers-button">
          読み取り画面に戻る
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import Header from '@/components/Header.vue';

export default {
  name: 'Log',
  components: {
    Header,
  },
  data() {
    return {
      logList: [],
    };
  },
  created() {
    axios.get('/api/v1/records')
      .then((res) => {
        this.logList = res.data;
      });
  },
};
</script>

<style scoped>
  .main {
    height: calc(100vh - 200px);
    width: 100vw;
    padding-top: 30px;
    background-color: #ffefbe;
  }

  .table-wrapper {
    max-height: calc(100vh - 300px);
    overflow-y: auto;
  }

  table {
    margin: auto;
    font-size: 25px;
    text-align: center;
    border-collapse: collapse;
  }

  thead {
    background-color: #f8931f;
    color: white;
  }

  th {
    padding: 10px;
  }

  tbody {
    padding: 10px;
    overflow-y: scroll;
  }

  td {
    padding: 5px 20px;
    border: 2px solid #f8931f;
  }

  td:first-child {
    border-left: none;
  }

  td:last-child {
    border-right: none;
  }

  .button-container {
    position: relative;
  }

  .cers-button {
    padding: 10px 30px;
    margin: 10px;
    border-radius: 10px;
    border: solid 3px white;
    background-color: #f8931f;
    color: white;
    font-size: 30px;
    text-decoration: none;
  }

  .button-wrapper {
    position: absolute;
    right: 100px;
    bottom: 50px;
  }
</style>
