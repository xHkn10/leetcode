import pandas as pd

data = [[1, 100], [2, 200], [3, 300]]
employee = pd.DataFrame(data, columns=['Id', 'Salary']).astype({'Id': 'Int64', 'Salary': 'Int64'})


def nth_highest_salary(employee: pd.DataFrame, N: int) -> pd.DataFrame:
    employee.drop_duplicates(subset="Salary", inplace=True)
    if len(employee) <= N - 1:
        return pd.DataFrame(data=[None], columns=[f"getNthHighestSalary({N})"])
    return employee.sort_values("Salary", ascending=False)[N - 1:N]["Salary"].to_frame().rename(
        columns={"Salary": f"getNthHighestSalary({N})"})


print(nth_highest_salary(employee, 2))
