export const config = {
  headers: {
    "Content-Type": "application/json",
    userid: localStorage.getItem("userid"),
    token: localStorage.getItem("token"),
  },
};
export const reducer = (state, action) => {
  switch (action.type) {
    case "update_input":
      return {
        ...state,
        [action.key]: action.value,
      };
    case "reset_form":
      return { ...state, form: {} };
    default:
      return state;
  }
};
