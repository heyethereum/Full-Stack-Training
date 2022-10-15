import { useEffect, useState } from "react";
import axios from "axios";

const useFetchData = (url, config) => {
  const [data, setData] = useState({});
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const { data: response } = await axios.get(url, config);
        setData(response);
      } catch (error) {
        console.log(error);
      }
      setLoading(false);
    };
    fetchData();
  }, [url, config]);

  return { data, loading };
};

export default useFetchData;
