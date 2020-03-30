# CERS - COVID-19 Entrance Recording System

![eslint](https://github.com/Yukiho-YOSHIEDA/CERS/workflows/eslint/badge.svg?branch=master&event=push)
![JUnit](https://github.com/Yukiho-YOSHIEDA/CERS/workflows/JUnit/badge.svg?branch=master&event=push)
![Version 1.0](https://img.shields.io/badge/version-1.0-yellow.svg)
[![MIT License](http://img.shields.io/badge/license-MIT-blue.svg?style=flat)](LICENSE)

[English](./README.md) | 日本語

部屋の入退室を記録するシステム

![Screenshots](./screenshots.png)

## 必須要件
* Java OpenJDK 11
* docker-compose
* Node.js v12.16.1

## ダウンロード
* [v1.0(latest)](https://github.com/Yukiho-YOSHIEDA/CERS/releases/download/v1.0/cers-1.0.jar)
* [v0.1](https://github.com/Yukiho-YOSHIEDA/CERS/releases/download/v0.1/cers-0.0.1-SNAPSHOT.jar)

## 起動方法
`$ java -jar cers.jar`
* デフォルトのポートは8080です。
* ポートを80にしたいときは、`$ java -Dserver.port=80 -jar cers.jar`で起動します。

## 開発環境における起動方法
1. このリポジトリをクローンしてください。
1. ターミナルで`$ cd cers`を実行してください。
1. `$ docker-compose up -d`を実行してください。
1. MacOSか、Linuxでは`$ ./gradlew bootRun`を、windowsでは`$ ./gradlew.bat bootRun`を実行してください。
1. http://localhost:8080 にアクセスしてください。

## フロントエンドの開発環境における起動方法
1. ターミナルで`$ cd cers/front`を実行してください。
1. `$ npm run serve`を実行してください。

## ビルド方法
1. ターミナルで`$ cd cers`を実行してください。
1. MacOSか、Linuxでは`$ ./gradlew build`を、windowsでは`$ ./gradlew.bat build`を実行してください。
1. ビルドに成功すると.jarファイルが`build/libs`に生成されます。

## API docs
本プロジェクトはSwagger UIをサポートしています。
1. CERSの開発環境を実行してください。
1. http://localhost:8080/swagger-ui.html にアクセスしてください。

## 読み取り端末
* [CERS-terminal](https://github.com/greenlaver/CERS-terminal) by Aonori.

## ライセンス
MIT License
