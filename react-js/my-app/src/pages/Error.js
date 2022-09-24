import { useNavigate } from "react-router-dom";

const Error = () => {
  const navigate = useNavigate();
  return (
    <section className="section">
      <h2>404</h2>
      <p>page not found</p>
      <div className="btn" onClick={() => navigate(-1)}>
        Go back
      </div>
    </section>
  );
};
export default Error;
