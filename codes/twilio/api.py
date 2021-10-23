#!/bin/python3

import math
import os
import random
import re
import sys



#
# Complete the 'getTotalGoals' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. STRING team
#  2. INTEGER year

import requests

def getTotalGoals(team, year):
    goal_sum=0
    try:
        # Write your code here
          ###As a team 1 data ###################################
        url = ("https://jsonmock.hackerrank.com/api/football_matches?year={}&team1={}&page=1".format(year,team))
        response = requests.get(url).json()
        total_page=response['total_pages']
        per_page=response['per_page']
        
        for page in range(1,total_page+1):
            url = ("https://jsonmock.hackerrank.com/api/football_matches?year={}&team1={}&page={}".format(year,team,page))
            response = requests.get(url).json()
            try:
                for i in range(0,per_page):
                    team1=response['data'][i]['team1goals']
                    goal_sum+=int(team1)
            except:
                pass
        url1 = ("https://jsonmock.hackerrank.com/api/football_matches?year={}&team2={}&page=1".format(year,team))
        response1 = requests.get(url1).json()
        total_page1=response1['total_pages']
        per_page1=response1['per_page']

        for page in range(1,total_page1+1):
            url1 = ("https://jsonmock.hackerrank.com/api/football_matches?year={}&team2={}&page={}".format(year,team,page))
            response1 = requests.get(url1).json()
        # print(total_data)
            try:
                for i in range(0,per_page1):
                    team2=response1['data'][i]['team2goals']
                    goal_sum+=int(team2)
            except:
                pass

    except Exception as err:
        print(err)
    finally:
        return goal_sum
    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')
    team = input()
    year = int(input().strip())
    result = getTotalGoals(team, year)
    fptr.write(str(result) + '\n')
    fptr.close()