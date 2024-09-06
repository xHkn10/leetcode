import pandas as pd

data = [[1, 3.5], [2, 3.65], [3, 4.0], [4, 3.85], [5, 4.0], [6, 3.65]]
scores = pd.DataFrame(data, columns=['id', 'score']).astype({'id': 'Int64', 'score': 'Float64'})


def order_scores(scores: pd.DataFrame) -> pd.DataFrame:
    scores = scores.sort_values("score", ascending=False, ignore_index=True)["score"].to_frame()
    scores["rank"] = tuple(range(1, len(scores) + 1))

    for i in range(len(scores)):
        if i == 0: continue
        if scores.at[i - 1, "score"] == scores.at[i, "score"]:
            scores.at[i, "rank"] = scores.at[i - 1, "rank"]
        else:
            scores.at[i, "rank"] = scores.at[i - 1, "rank"] + 1

    return scores


print(order_scores(scores))
