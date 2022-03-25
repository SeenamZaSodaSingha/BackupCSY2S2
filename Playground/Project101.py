from selenium import webdriver
import webbrowser

driver = webdriver.Chrome()

url = "https://www.rapidtables.com/tools/click-counter.html"
driver.get(url)
button = driver.find_element_by_id('addbtn')
button.click()

# import requests
# import json


# url = "https://pearls.science.kmitl.ac.th/api/teamcompetition/submit"

# for i in range(100):
#         payload = json.dumps({
#             "code": "import java.util.Scanner;\n\nclass Main{\n    public static void main(String[] args) {\n      Scanner sc = new Scanner(System.in);\n      int n = sc.nextInt();\n\n      switch(n) {\n        case 0: System.out.println(1); break;\n        case 1: System.out.println(1); break;\n        case 2: System.out.println(2); break;\n        case 3: System.out.println(6); break;\n        case 4: System.out.println(24); break;\n        case 5: System.out.println(120); break;\n        case 6: System.out.println(720); break;\n        case 7: System.out.println(5040); break;\n        case 8: System.out.println(40320); break;\n        case 9: System.out.println(362880); break;\n        case 10: System.out.println(3628800); break;\n        default: System.out.println(0);\n      }\n    }\n}",
#             "problem_id": 29
#         })
#         headers = {
#             'content-Type': 'application/json',
#             'authorization': 'Bearer ya29.a0ARrdaM--UD7I82PXonYX0lVZd-s-BgH-TGiAzjpWmtrWkPZbJcwiE1TLPU4sM_59Bw6Q-b6wzRVgliSKVapLst28D-dPw3aEBhYhiiCJY4coFnQ6oIYXWKbpaQZi9Q9cCsxzqxjB6WmxjN5gyRnbA6CqFRJhedk',
#             'sec-fetch-mode': 'cors'
#         }

#         response = requests.request("POST", url, headers=headers, data=payload)
#         print(response.text) 