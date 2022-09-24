import { useNavigate, useParams } from "react-router-dom";
import products from "../data";
const SingleProduct = () => {
  const { productId } = useParams();
  const product = products.find((product) => product.id === productId);
  const { image, name } = product;
  const navigate = useNavigate();
  return (
    <section className="section product">
      <img src={image} alt={name} />
      <h5>{name}</h5>
      <div
        className="btn"
        onClick={() => {
          navigate(-1);
        }}
      >
        back to products
      </div>
    </section>
  );
};

export default SingleProduct;
