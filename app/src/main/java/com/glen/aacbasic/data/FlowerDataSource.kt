package com.glen.aacbasic.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.random.Random

interface FlowerDataSource {
    suspend fun getFlowers(): List<Flower>
}

class FlowerDataSourceImpl : FlowerDataSource {

    override suspend fun getFlowers(): List<Flower> {
        return withContext(Dispatchers.IO) {
            delay(1000)
            createMockFlowers().subList(0, Random.nextInt(0, 9))
        }
    }

    private fun createMockFlowers(): List<Flower> {
        return listOf(
            Flower(
                name = "칼랑코에",
                image = "https://search3.kakaocdn.net/argon/130x130_85_c/1u2KQeDWaGF",
                flowerLanguage = "인기, 설레임"
            ),
            Flower(
                name = "금전수",
                image = "https://search2.kakaocdn.net/argon/130x130_85_c/BDhaCVlm8l5",
                flowerLanguage = "번영"
            ),
            Flower(
                name = "라벤더",
                image = "https://search4.kakaocdn.net/argon/130x130_85_c/4GZDuly1BJ2",
                flowerLanguage = "정절, 풍부한 향기, 기대"
            ),
            Flower(
                name = "꼬리풀",
                image = "https://search2.kakaocdn.net/argon/130x130_85_c/1hlHEG2RZWx",
                flowerLanguage = "달성"
            ),
            Flower(
                name = "사과나무꽃",
                image = "https://search4.kakaocdn.net/argon/130x130_85_c/GDKXaSQpTnF",
                flowerLanguage = "유혹"
            ),
            Flower(
                name = "엘라티오르베고니아",
                image = "https://search4.kakaocdn.net/argon/130x130_85_c/fW5zZv2RmK",
                flowerLanguage = "진정한 아름다움"
            ),
            Flower(
                name = "산호수",
                image = "https://search1.kakaocdn.net/argon/130x130_85_c/42AL8MqL0ao",
                flowerLanguage = "용감, 총명"
            ),
            Flower(
                name = "장미",
                image = "https://search4.kakaocdn.net/argon/130x130_85_c/BuFpQOKDZzw",
                flowerLanguage = "욕망, 열정, 기쁨"
            ),
            Flower(
                name = "유채꽃",
                image = "https://search4.kakaocdn.net/argon/130x130_85_c/ENosZiTddJg",
                flowerLanguage = "쾌활"
            ),
            Flower(
                name = "수국",
                image = "https://search2.kakaocdn.net/argon/130x130_85_c/6eXscw54333",
                flowerLanguage = "변덕, 진심"
            )
        )
    }
}