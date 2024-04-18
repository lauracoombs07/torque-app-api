package com.torque.trainingapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TrainingAppApplication

fun main(args: Array<String>) {
	runApplication<TrainingAppApplication>(*args)
}
