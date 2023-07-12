from django.contrib import admin
from django.urls import path
from app import views

urlpatterns = [
    path('predict/',views.predict_price,name='predict_price'),
]