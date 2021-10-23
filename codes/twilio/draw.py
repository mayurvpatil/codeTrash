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


def getTotalGoals(year):
    draw_count = 0
    try:

        for score in range(0, 10):
            url = ("https://jsonmock.hackerrank.com/api/football_matches?year={}&team1goals={}&team2goals={}".format(year, score, score))
            print(url)
            response = requests.get(url).json()
            # print(response['data'])
            draw_count += response['total']

    except Exception as err:
        print(err)
    finally:
        return draw_count


if __name__ == '__main__':
    result = getTotalGoals(2011)
    print(result)
