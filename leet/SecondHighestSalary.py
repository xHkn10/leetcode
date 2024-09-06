import pandas as pd

data = [[1, 100], [2, 100]]
employee = pd.DataFrame(data, columns=['id', 'salary']).astype({'id':'int64', 'salary':'int64'})

def second_highest_salary(employee: pd.DataFrame) -> pd.DataFrame:
    employee.drop_duplicates(subset="salary", inplace=True)
    if len(employee) <= 1:
        return pd.DataFrame(data=[None], columns=["SecondHighestSalary"])
    df = employee.sort_values("salary", ascending=False)[1:2]["salary"].to_frame().rename(columns={"salary": "SecondHighestSalary"})
    return df


print(second_highest_salary(employee))