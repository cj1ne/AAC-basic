package com.glen.aacbasic.data

interface FlowerRepository {
    suspend fun fetchFlowers(): List<Flower>
}

class FlowerRepositoryImpl: FlowerRepository {

    private val dataSource: FlowerDataSource = FlowerDataSourceImpl()

    override suspend fun fetchFlowers(): List<Flower> {
        return dataSource.getFlowers()
    }
}