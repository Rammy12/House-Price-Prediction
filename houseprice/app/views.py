from django.shortcuts import render

# Create your views here.

import pandas as pd
import numpy as np
import pickle
from rest_framework.response import Response
from rest_framework.decorators import api_view
import sklearn



#pipe=pickle.load(open('house_price_model.pkl','rb'))



#input=pd.DataFrame([[location,sqft,bath,bhk]],columns=['location','total_sqft','bath','bhk'])
#prediction=pipe.predict(input)[0]*1e5
#prediction=np.round(prediction,2)


@api_view(['POST'])
def predict_price(request):
    try:
        location=request.data.get('location',None)
        bhk=request.data.get('bhk',None)
        bath=request.data.get('bath',None)
        sqft=request.data.get('total_sqft',None)
        fields=[location,sqft,bath,bhk]
        if not None in fields:
            sqft=float(sqft)
            bath=float(bath)
            input=pd.DataFrame([[location,sqft,bath,bhk]],columns=['location','total_sqft','bath','bhk'])
            model_path='model/house_peice_model2.pkl'
            pipe=pickle.load(open(model_path,'rb'))
            prediction=pipe.predict(input)[0]*1e5
            prediction=np.round(prediction,2)
            #conf_score=np.max(pipe.predict_proba([prediction]))*100
            predictions={
                'error':'0',
                'message':'Successfull',
                'Prediction':prediction
            }
        else:
            predictions={
                'error':'1',
                'message':'Invalid'
            }
    except Exception as e:
        print(sklearn.__version__)
        predictions={
            'error':'1',
            'message':str(e)
        }
    return Response(predictions)


