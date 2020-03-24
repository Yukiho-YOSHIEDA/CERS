<template>
  <div class="index">
    <Header />
    <div class="main">
      <div class="standby" v-if="isStandby">
        <div class="card">
          <img alt="card" src="../assets/card.png" />
        </div>
        <div class="description">
          <div class="description-item">学生証をリーダーに</div>
          <div class="description-item">かざしてください</div>
        </div>
      </div>
      <div class="logged" v-if="!isStandby">
        <div class="readed">
          読み取り完了
        </div>
        <div class="description">
          <div class="student-no">{{ log.id }}</div>
          <div class="name">{{ log.name }}さん</div>
          <div class="mode">が{{ log.mode == 'enter' ? "入室" : "退室" }}しました</div>
        </div>
      </div>
    </div>
    <div class="button-container">
      <router-link to="/log" tag="button" class="cers-button log-button">
        ログを表示
      </router-link>
    </div>
  </div>
</template>

<script>
import SockJS from 'sockjs-client';
import Stomp from 'webstomp-client';
import Header from '@/components/Header.vue';

let stompClient = null;

export default {
  name: 'Index',
  components: {
    Header,
  },
  data() {
    return {
      isStandby: true,
      log: null,
    };
  },
  mounted() {
    const socket = new SockJS('/sockws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, () => {
      stompClient.subscribe('/record/updated', (data) => {
        this.log = JSON.parse(data.body);
        this.isStandby = false;
        setTimeout(() => {
          this.isStandby = true;
        }, 3000);
      });
    });
  },
};
</script>

<style scoped>
  .main {
    height: calc(100vh - 170px);
    width: 100vw;
    background-color: #ffefbe;
  }

  .standby {
    height: 100%;
    display: flex;
    align-items: center;
  }

  .card {
    padding-left: 30px;
  }

  .description {
    width: 100%;
  }

  .description-item {
    padding: 10px;
    text-align: center;
    font-size: 60px;
  }

  .button-container {
    position: relative;
  }

  .logged {
    height: calc(100% - 30px);
    padding-top: 30px;
  }

  .readed {
    text-align: center;
    margin: 0px 150px 30px 150px;
    padding: 30px;
    border: 5px solid #f8931f;
    font-size: 45px;
  }

  .logged > .description {
    margin: 50px 150px;
    width: auto;
  }

  .student-no {
    padding: 10px 0px;
    font-size: 30px;
  }

  .name {
    padding: 10px 0px;
    font-size: 60px;
  }

  .mode {
    text-align: right;
    padding: 10px 0px;
    font-size: 60px;
  }

  .cers-button {
    padding: 10px 30px;
    margin: 10px;
    border-radius: 10px;
    border: solid 3px white;
    background-color: #f8931f;
    color: white;
    font-size: 30px;
  }

  .log-button {
    position: absolute;
    right: 100px;
    bottom: 50px;
  }

</style>
