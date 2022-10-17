export const config = ({ token }) => {
  return {
    headers: {
      "Content-Type": "application/json",
      token: token,
    },
  };
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
