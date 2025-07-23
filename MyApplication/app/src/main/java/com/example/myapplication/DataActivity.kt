package com.example.myapplication
//
//import android.car.Car
//import android.car.hardware.property.CarPropertyManager
//import android.car.hardware.property.CarPropertyValue
//import android.car.VehiclePropertyIds
//import androidx.appcompat.app.AppCompatActivity
//
//// This is a simplified example to show the concept.
//class DataActivity : AppCompatActivity() {
//
//    private lateinit var car: Car
//    private lateinit var propertyManager: CarPropertyManager
//
//    fun connectToCar() {
//        // 1. Get an instance of the Car object.
//        car = Car.createCar(this)
//
//        // 2. Get the Property Manager, which gives you access to vehicle data.
//        propertyManager = car.getCarManager(Car.PROPERTY_SERVICE) as CarPropertyManager
//
//        // 3. Register a callback to listen for changes in the car's speed.
//        propertyManager.registerCallback(
//            object : CarPropertyManager.CarPropertyEventCallback {
//                override fun onChangeEvent(value: CarPropertyValue<*>) {
//                    // This function is called whenever the speed changes.
//                    val currentSpeed = value.value as Float
//                    // Now you can update your UI with the new speed.
//                    println("Current Speed: $currentSpeed m/s")
//                }
//                override fun onErrorEvent(propId: Int, zone: Int) {}
//            },
//            VehiclePropertyIds.PERF_VEHICLE_SPEED, // This ID specifies that we want the vehicle speed.
//            CarPropertyManager.CAR_PROPERTY_RATE_NORMAL
//        )
//    }
//}